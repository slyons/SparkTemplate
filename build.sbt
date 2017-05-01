
name := "SparkTemplate"

version := "1.0"

scalaVersion := "2.11.11"

// Uncomment these before deployment!
libraryDependencies ++= Seq (
  "com.typesafe" % "config" % "1.2.1",
  "org.apache.spark" %% "spark-core" % "2.0.2" /*% "provided"*/,
  "org.apache.spark" %% "spark-sql" % "2.0.2" /*% "provided"*/,
  "org.apache.spark" %% "spark-hive" % "2.0.2"  /*% "provided"*/,
  "org.apache.spark" %% "spark-streaming" % "2.0.2" /*% "provided"*/,
  "com.iheart" %% "ficus" % "1.4.0"
)

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case PathList("org", "slf4j", xs @ _*) => MergeStrategy.discard
  case PathList("org", "apache", "log4j", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

assemblyJarName in assembly := s"sparktemplate-${version.value}.jar"