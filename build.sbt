import sbt.Keys.scalaVersion

ThisBuild / scalaVersion := "2.13.5"

lazy val coreDependencies = Seq("org.typelevel" %% "cats-core" % "2.3.1")

lazy val allDependencies =
  coreDependencies ++ Seq(
    "org.typelevel" %% "cats-effect" % "2.3.1",
    "com.typesafe" % "config" % "1.4.1"
  )

lazy val service = project
  .settings(
    libraryDependencies ++= allDependencies
  )
  .in(file("service"))
  .aggregate(core)
  .dependsOn(core)

lazy val core = project
  .settings(
    libraryDependencies ++= coreDependencies
  )
  .in(file("core"))
