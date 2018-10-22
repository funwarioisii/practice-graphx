name := "graphx-practice"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.apache.spark" %% "spark-core" % "2.0.2",
  "org.apache.spark" %% "spark-graphx" % "2.0.2",
  "com.github.etaty" %% "rediscala" % "1.8.0"
)
