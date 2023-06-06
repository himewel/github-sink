package com.himewel

import scopt.OParser
import com.himewel.sink._

case class CLIConfig(
  command: String = "",
  sink: SinkMethod = Console(),
  configFile: Option[String] = None,
  repo: Option[String] = None,
  user: Option[String] = None,
)

object CLIConfig {
  val builder = OParser.builder[CLIConfig]
  val argParser = {
    import builder._

    OParser.sequence(
      programName("GithubAPI"),
      head("GithubAPI", "0.1"),
      opt[String]('s', "sink")
        .optional()
        .action(
          (r, c) => c.copy(sink=SinkMethod.build(r)))
        .text("Destination type, by default its console"),
      opt[String]('f', "config-file")
        .optional()
        .action((r, c) => c.copy(configFile=Some(r)))
        .text("Path for sink configuration, required depending on destination type"),
      cmd("repo")
        .required()
        .action((_, c) => c.copy(command="repo"))
        .children(
          opt[String]('r', "repo")
            .required()
            .action((r, c) => c.copy(repo=Some(r)))
            .text("Github repo's name"),
          opt[String]('u', "user")
            .required()
            .action((u, c) => c.copy(user=Some(u)))
            .text("Github user's name")
        ),
      cmd("user")
        .required()
        .action((_, c) => c.copy(command="user"))
        .children(
          opt[String]('u', "user")
            .required()
            .action((u, c) => c.copy(user=Some(u)))
            .text("Github user's name")
        ),
    )
  }
}
