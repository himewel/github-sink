# GithubAPI Sink

Extract data from Github API and sink it for external sources! The main objective of this project its exercise some practices using Scala language and libraries derived from Cats for functional programming, such as Circe and Doobie.

Currently, the CLI menu has the following options:

```bash
GithubAPI 0.1
Usage: GithubAPI [repo|user] [options]

  -s, --sink <value>      Destination type, by default its console
  -c, --config <value>    Path for sink configuration, required depending on destination type
Command: repo [options]

  -r, --repo <value>      Github repo's name
  -u, --user <value>      Github user's name
Command: user [options]

  -u, --user <value>      Github user's name
```

For now, there is only Console sink implemented but soon it will be released a Sink for SQL databases using Doobie. So keep keep following to check out the news!