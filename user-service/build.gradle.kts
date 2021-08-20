plugins{
    scala
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.UserApp")
}

val akkaHttpVersion = "10.2.6"
val akkaVersion    = "2.6.15"

dependencies {
    implementation("org.scala-lang:scala-library:2.13.6")
    implementation("com.typesafe.akka:akka-http_2.13:${akkaHttpVersion}")
    implementation("com.typesafe.akka:akka-http-spray-json_2.13:${akkaHttpVersion}")
    implementation("com.typesafe.akka:akka-actor-typed_2.13:${akkaVersion}")
    implementation("com.typesafe.akka:akka-stream_2.13:${akkaVersion}")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("com.typesafe.akka:akka-http-testkit_2.13:${akkaHttpVersion}")
    testImplementation("com.typesafe.akka:akka-actor-testkit-typed_2.13:${akkaVersion}")
    testImplementation("org.scalatest:scalatest_2.13:3.1.4")
}