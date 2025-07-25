val catsEffectVersion = "3.6.3"

val catseffect = Seq(
  "org.typelevel" %% "cats-effect" % catsEffectVersion withSources () withJavadoc ()
)

val logging = Seq(
  "org.slf4j" % "slf4j-api" % "2.0.17",
  "ch.qos.logback" % "logback-classic" % "1.5.18",
  "ch.qos.logback" % "logback-core" % "1.5.18",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "org.typelevel" %% "log4cats-slf4j" % "2.7.1"
)

val config = Seq("com.typesafe" % "config" % "1.4.3")

val test = Seq(
  "org.scalactic" %% "scalactic" % "3.2.19" % Test,
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.typelevel" %% "cats-effect-testing-scalatest" % "1.6.0" % Test withSources () withJavadoc ()
)

lazy val cats_effect = (project in file("."))
  .settings(
    name := "cats_effect",
    version := "0.0.1-SNAPSHOT",
    libraryDependencies ++= logging,
    libraryDependencies ++= catseffect,
    libraryDependencies ++= config,
    libraryDependencies ++= test,
    scalaVersion := "3.3.6"
  )

Compile / run / fork := true

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-explaintypes", // Explain type errors in more detail.
  "-Xfatal-warnings" // Fail the compilation if there are any warnings.
)

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*)       => MergeStrategy.discard
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case _                                   => MergeStrategy.first
}
