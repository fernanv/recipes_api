name := """Recipes API"""
organization := "com.fernando_villalba"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies ++= Seq("org.json" % "json" % "20211205", guice)

enablePlugins(PlayEbean)
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "com.h2database" % "h2" % "1.4.200"

libraryDependencies ++= Seq(
  ehcache
)