package com.himewel.sink

import cats._
import cats.implicits._
import com.himewel.models._
import io.circe.Encoder, io.circe.syntax._
import scala.util.{ Try, Success, Failure }
import java.io.PrintWriter

trait Sink[A] {
  def run[E: Encoder](value: E, config: Map[String, String]): Boolean
}

object Sink {
  implicit val mongoSink: Sink[MongoDB] = new MongoSink()

  implicit val consoleSink: Sink[Console] = new Sink[Console] {
    def run[E: Encoder](value: E, config: Map[String, String]): Boolean = {
      println(value.asJson)
      true 
    }
  }

  implicit val fileSink: Sink[File] = new Sink[File] {
    def run[E: Encoder](value: E, config: Map[String, String]): Boolean = {    
      val path = 
        (config.get("path"), config.get("name"))
        .mapN((a, b) => s"${a}/${b}")
        .getOrElse("./output.json")

      new PrintWriter(path) { 
        write(value.asJson.toString)
        close 
      }
      true
    }
  }

  def send[E: Encoder, A](fa: Option[E], config: Map[String, String])(implicit ev: Sink[A]): Try[Boolean] = Try {
    fa match {
      case None => throw new Exception("Invalid object")
      case Some(value) => ev.run(value, config)
    }
  }
}
