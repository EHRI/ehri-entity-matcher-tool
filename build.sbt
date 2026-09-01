import com.typesafe.sbt.packager.MappingsHelper.directory

name := "emt"
organization := "eu.ehri_project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SbtWeb, LauncherJarPlugin)

scalaVersion := "2.13.18"

// This prevents a library version incompatibility error between
// scala-xml 1.3.0 and 2.2.0 (which are in fact binary compatible.)
ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
)


libraryDependencies += guice
libraryDependencies += ws
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.6"
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % "2.11.4"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "eu.ehri.project.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "eu.ehri.project.binders._"

pipelineStages := Seq(digest)

// Dist options
topLevelDirectory := None

Universal / mappings ++= directory("bin")
