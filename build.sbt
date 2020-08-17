name := """play-java-myapp"""
organization := "com.toshi.play"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.3"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

libraryDependencies += guice
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += evolutions

