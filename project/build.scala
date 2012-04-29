import sbt._,Keys._

object build extends Build{

  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    javacOptions ++= Seq("-Xlint"),
    autoScalaLibrary := false,
    libraryDependencies ++= Seq(
      "org.projectlombok" % "lombok" % "0.11.0"
    ),
    shellPrompt in ThisBuild := { state =>
      Project.extract(state).currentRef.project + "> "
    }
  )

  lazy val root = Project(
    "root",
    file(".")
  )aggregate(core,sample)

  lazy val core = Project(
    "core",
    file("core"),
    settings = buildSettings ++ Seq(
      libraryDependencies ++= Seq(
        "org.slf4j" % "slf4j-api" % "1.6.4"
      )
    )
  )

  lazy val sample = Project(
    "sample",
    file("sample"),
    settings = buildSettings ++ Seq(
      libraryDependencies ++= Seq(
        "junit" % "junit" % "3.8.1" % "test"
       ,"com.novocode" % "junit-interface" % "0.8" % "test->default"
      )
    )
  ) dependsOn(core)
}

