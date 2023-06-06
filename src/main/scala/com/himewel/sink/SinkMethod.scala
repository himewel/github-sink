package com.himewel.sink

import io.circe._, io.circe.parser._
import scala.io.Source
import scala.util.Try

sealed trait SinkMethod
case class Console() extends SinkMethod
case class File() extends SinkMethod

object SinkMethod {
  def build(name: String): SinkMethod = 
    name match {
      case "console" => Console()
      case "file" => File()
      case _: String => Console()
    }

  def getConfig(configFile: Option[String]): Map[String, String] = {
    val jsonString = configFile match {
      case None => ""
      case Some(value) => Source.fromFile(value).mkString
    }

    decode[Map[String, String]](jsonString) match {
      case Left(error) => Map[String, String]()
      case Right(value) => value
    }
  }

  def getSinkExecutor[A: Encoder](sinkMethod: SinkMethod, configFile: Option[String]): (Option[A]) => Try[Boolean] = {
    val config = getConfig(configFile)

    (value) => 
      sinkMethod match {
        case Console() => Sink.send[A, Console](value, config)
        case File() => Sink.send[A, File](value, config)
      }
  }
}
