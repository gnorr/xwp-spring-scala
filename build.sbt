name := "xwp"

organization := "org.norr"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

seq(webSettings :_*)

env in Compile := Some(file(".") / "jetty-env.xml" asFile)

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "commons-dbcp" % "commons-dbcp" % "1.4",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
  "jstl" % "jstl" % "1.2",
  "mysql" % "mysql-connector-java" % "5.1.28",
  "org.apache.tiles" % "tiles-jsp" % "2.1.4",
  "org.apache.tiles" % "tiles-servlet" % "2.1.4",
  "org.eclipse.jetty" % "jetty-jsp" % "9.1.1.v20140108" % "container",
  "org.eclipse.jetty" % "jetty-plus" % "9.1.1.v20140108" % "container",
  "org.hibernate" % "hibernate-core" % "4.2.8.Final",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.5",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.springframework" % "spring-orm" % "3.2.6.RELEASE",
  "org.springframework" % "spring-webmvc" % "3.2.6.RELEASE",
  "org.webjars" % "bootstrap" % "2.3.2"
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "org.springframework" % "spring-test" % "3.2.6.RELEASE"
)
