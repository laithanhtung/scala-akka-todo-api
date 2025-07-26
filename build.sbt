name := "todo-api"

version := "0.1"

scalaVersion := "2.13.10"

libraryDependencies ++= Seq(
 "com.typesafe.akka" %% "akka-actor" % "2.6.20",
 "com.typesafe.akka" %% "akka-stream" % "2.6.20",
 "com.typesafe.akka" %% "akka-http" % "10.2.9",
 "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.9"
)

// Thêm cấu hình assembly (nếu có)
ThisBuild / assemblyMergeStrategy := {
 case PathList("META-INF", _*) => MergeStrategy.discard
 case "reference.conf" | "application.conf" => MergeStrategy.concat
 case "module-info.class" => MergeStrategy.discard
 case _ => MergeStrategy.first
}