ThisBuild / scalaVersion := "3.5.2"
ThisBuild / organization := "kse"

lazy val root = (project in file("."))
  .settings(
    name := "scala-functional-programming",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.18.1" % Test,
    // ScalaCheck's Properties objects are run as test mains
    testFrameworks += new TestFramework("org.scalacheck.ScalaCheckFramework"),
  )
