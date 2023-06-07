scalaVersion := "2.13.10"
Compile / mainClass := Some("com.himewel.GithubApp")
Test / fork := true

lazy val root = (project in file("."))
  .settings(
    name := "githubapi-sink",
    organization := "com.himewel"
  )

libraryDependencies := Seq(
  "org.typelevel" %% "cats-core" % "2.9.0",
  "com.github.scopt" %% "scopt" % "4.1.0",
  "io.circe" %% "circe-core" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1",
  "org.mongodb.scala" %% "mongo-scala-driver" % "4.9.0",
  "io.circe" %% "circe-testing" % "0.14.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.1" % "test",
  "org.scalatest" %% "scalatest" % "3.2.16" % "test",
  "org.typelevel" %% "discipline-core" % "1.5.0" % "test",
  "org.typelevel" %% "discipline-scalatest" % "2.2.0" % "test",
)

assembly / assemblyMergeStrategy := {
 case PathList("META-INF", _*) => MergeStrategy.discard
 case _ => MergeStrategy.first
}