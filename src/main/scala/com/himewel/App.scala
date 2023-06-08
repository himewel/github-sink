package com.himewel

import io.circe._
import com.himewel.sink._
import com.himewel.models._
import scala.util.Failure
import scopt.OParser

object GithubApp extends App {
  OParser.parse(CLIConfig.argParser, args, CLIConfig()) match {
    case Some(config) =>
      val value = config.command match {
        case "user" =>
          val user = config.user.get
          val sink = SinkMethod.getSinkExecutor[User](config.sink, config.configFile)
          sink(GithubAPI.getUser(user))

        case "repo" =>
          val user = config.user.get
          val repo = config.repo.get
          val sink = SinkMethod.getSinkExecutor[Repo](config.sink, config.configFile)
          sink(GithubAPI.getRepo(user, repo))

        case _: String =>
          println(OParser.usage(CLIConfig.argParser))
          System.exit(0)
          None
      }

      println(value)
    case None =>
      System.exit(1)
  }
}
