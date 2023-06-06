package com.himewel.sink

import com.himewel.models._
import io.circe._, io.circe.syntax._
import scala.util.{ Try, Success, Failure }

trait SinkMethod
case class Console() extends SinkMethod  

object SinkMethod {
  def build(name: String): SinkMethod = 
    name match {
      case "console" => Console()
      case _: String => Console()
    }

  def getSinkExecutor[A: Encoder](sinkMethod: SinkMethod): Option[A] => Try[Boolean] = (value) => 
    sinkMethod match {
      case Console() => Sink.send[A, Console](value)
      case _: SinkMethod => Sink.send[A, Console](value)
    }
}

trait Sink[A] {
  def run[E: Encoder](value: E): Boolean
}

object Sink {
  implicit val consoleSink: Sink[Console] = new Sink[Console] {
    def run[E: Encoder](value: E): Boolean = {
      println(value.asJson)
      true 
    }
  }

  def send[E: Encoder, A](fa: Option[E])(implicit ev: Sink[A]): Try[Boolean] = Try {
    fa match {
      case None => throw new Exception("Invalid object")
      case Some(value) => ev.run(value)
    }
  }
}
