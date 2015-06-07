name := "type-prog-ws"

organization := "com.joescii"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= {
  Seq(
    "org.scalatest"  %% "scalatest"   % "2.2.3" % "test",
    "com.chuusai"    %% "shapeless"   % "2.2.1" % "test"
  )
}

scalacOptions <<= scalaVersion map { v: String =>
  "-deprecation" :: "-unchecked" :: "-feature" :: "-language:postfixOps" :: "-language:implicitConversions" :: "-language:higherKinds" :: Nil
}

parallelExecution in Test := false
