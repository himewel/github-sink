package com.himewel.sink

import io.circe._
import scala.util.Try

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
