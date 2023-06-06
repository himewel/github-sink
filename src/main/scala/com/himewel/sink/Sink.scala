package com.himewel.sink

import com.himewel.models._
import io.circe.Encoder, io.circe.syntax._
import scala.util.{ Try, Success, Failure }

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
