name := "slick_demo"

version := "1.0"

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "org.slf4j" % "slf4j-nop" % "1.7.26",
  "com.h2database" % "h2" % "1.4.199",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
  "org.scalatest" %% "scalatest" % "3.2.0-M2" % Test
)