# GithubAPI Sink

A Scala CLI that fetches data from the [GitHub REST API](https://docs.github.com/en/rest) and writes it to a configurable sink. The project explores functional programming with [Cats](https://typelevel.org/cats/) and JSON handling with [Circe](https://circe.github.io/circe/).

## Features

- Fetch **GitHub user** or **repository** metadata
- Write results to **console**, **file**, or **MongoDB**
- Type-safe models with Circe codecs (validated by property-based tests)
- Docker Compose examples for each sink

## Requirements

- Java 8 or later
- [sbt](https://www.scala-sbt.org/) 1.x (for local development)
- [Docker](https://www.docker.com/) and Docker Compose (optional, for containerized runs)

## Quick start

### Build and run locally

```bash
# Run with the default console sink
sbt "run user --user octocat"

# Fetch a repository
sbt "run repo --user octocat --repo Hello-World"
```

### Build a fat JAR

```bash
sbt assembly
java -jar target/scala-2.13/githubapi-sink-assembly-0.1.0-SNAPSHOT.jar user --user octocat
```

### Run tests

```bash
sbt test
```

## CLI usage

```
GithubAPI 0.1
Usage: GithubAPI [repo|user] [options]

  -s, --sink <value>         Destination type (default: console)
  -f, --config-file <value>  Path to sink configuration JSON (required for file and mongo)

Command: repo [options]
  -r, --repo <value>         Repository name
  -u, --user <value>         GitHub username or organization

Command: user [options]
  -u, --user <value>         GitHub username
```

### Examples

```bash
# Console (default) — prints JSON to stdout
sbt "run user --user octocat"

# File — writes JSON to disk
sbt "run user --user octocat --sink file --config-file docker/file/config.json"

# MongoDB — upserts document by id
sbt "run user --user octocat --sink mongo --config-file docker/mongodb/config.json"

# Repository lookup
sbt "run repo --user octocat --repo Hello-World --sink console"
```

## Sinks

| Sink      | CLI value | Config required | Description                          |
|-----------|-----------|-----------------|--------------------------------------|
| Console   | `console` | No              | Prints JSON to stdout (default)      |
| File      | `file`    | Yes             | Writes JSON to a file on disk        |
| MongoDB   | `mongo`   | Yes             | Upserts a document keyed by `id`     |

### File sink configuration

`docker/file/config.json`:

```json
{
  "path": "/root",
  "name": "output.json"
}
```

If `path` or `name` is missing, output defaults to `./output.json`.

### MongoDB sink configuration

`docker/mongodb/config.json`:

```json
{
  "connectionString": "mongodb://root:example@mongo:27017/",
  "database": "test",
  "collection": "user"
}
```

All three fields (`connectionString`, `database`, `collection`) are required.

## Docker

Build the assembly JAR before starting a Compose stack:

```bash
sbt assembly
```

Then run one of the example stacks from the repository root:

```bash
# Console sink
docker compose -f docker/console/docker-compose.yaml up --build

# File sink
docker compose -f docker/file/docker-compose.yaml up --build

# MongoDB sink (includes MongoDB and mongo-express on port 8081)
docker compose -f docker/mongodb/docker-compose.yaml up --build
```

## Project structure

```
src/main/scala/com/himewel/
├── App.scala           # CLI entry point
├── CliConfig.scala     # scopt argument parsing
├── GithubAPI.scala     # GitHub API client
├── models/             # User and Repo domain models
└── sink/               # Console, File, and MongoDB sinks

docker/
├── base/Dockerfile     # Runtime image with the assembly JAR
├── console/            # Console sink example
├── file/               # File sink example and config
└── mongodb/            # MongoDB sink example and config
```

## Dependencies

- [Cats](https://typelevel.org/cats/) — functional utilities
- [Circe](https://circe.github.io/circe/) — JSON encoding and decoding
- [scopt](https://github.com/scopt/scopt) — CLI parsing
- [MongoDB Scala Driver](https://mongodb.github.io/mongo-scala-driver/) — MongoDB sink
