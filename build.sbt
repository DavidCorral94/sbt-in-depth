import sbt.Keys.scalaVersion
import sbtassembly.AssemblyPlugin.autoImport.assemblyJarName
import ReleaseTransformations._

ThisBuild / scalaVersion := "2.13.5"
ThisBuild / coverageEnabled := true
ThisBuild / publishArtifact := false

assembly / assemblyJarName := "core.jar" // Updated, 'in' keyword deprecated ref: https://www.scala-sbt.org/1.x/docs/Migrating-from-sbt-013x.html#slash

lazy val coreDependencies = Seq("org.typelevel" %% "cats-core" % "2.3.1")

lazy val allDependencies =
  coreDependencies ++ Seq("org.typelevel" %% "cats-effect" % "2.3.1", "com.typesafe" % "config" % "1.4.1")

lazy val service =
  project
    .settings(libraryDependencies ++= allDependencies)
    .settings(coverageMinimum := 50, coverageFailOnMinimum := false)
    .settings(Compile / mainClass := Some("com.example.HelloWorld")) // Updated as line 8 // class is HelloWorld
    .settings(
      releaseProcess := Seq[ReleaseStep](
            checkSnapshotDependencies,
            inquireVersions,
            runClean,
            setReleaseVersion,
            commitReleaseVersion,
            tagRelease,
            setNextVersion,
            commitNextVersion))
    .in(file("service"))
    .aggregate(core)
    .dependsOn(core)
    .enablePlugins(JavaAppPackaging)
    .enablePlugins(DockerPlugin)

lazy val core = project
  .settings(libraryDependencies ++= coreDependencies)
  .in(file("core"))
  //.settings(assembly / assemblyJarName := "core.jar")
