val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-world",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
libraryDependencies += "org.infinispan" % "infinispan-commons" % "14.0.6.Final",
libraryDependencies += "org.infinispan" % "infinispan-client-hotrod" % "14.0.6.Final"
  )
