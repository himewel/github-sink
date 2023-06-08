package com.himewel

import com.himewel.models._
import io.circe._
import scala.io.Source.fromURL
import scala.util.{Try, Failure, Success}

trait HttpMethod

case class Get[A: Decoder](url: String) extends HttpMethod {
  @throws(classOf[java.io.IOException])
  @throws(classOf[Exception])
  def run(): Try[A] = Try {
    val response = fromURL(url).mkString
    val result = parser.decodeAccumulating[A](response)

    result.toEither match {
      case Left(error)  => throw new Exception(error.foldLeft("")((a, acc) => s"${acc}, ${a}"))
      case Right(value) => value
    }
  }
}

object GithubAPI {
  def getUser(user: String): Option[User] = {
    val req = Get[User](s"https://api.github.com/users/${user}")
    val res = req.run()

    res match {
      case Failure(exception) => println(exception); None
      case Success(user)      => Some(user)
    }
  }

  def getRepo(user: String, repo: String): Option[Repo] = {
    val req = Get[Repo](s"https://api.github.com/repos/${user}/${repo}")
    val res = req.run()

    res match {
      case Failure(exception) => println(exception); None
      case Success(repo)      => Some(repo)
    }
  }
}
