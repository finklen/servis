plugins {
    application
    id("org.springframework.boot") version("2.5.3")
    id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

group = "com.servis"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

repositories {
    mavenCentral()
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

dependencies {
    // This dependency is used by the application.
    implementation("io.projectreactor.kafka:reactor-kafka:1.3.5")
    implementation("org.springframework.kafka:spring-kafka:2.7.5")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    runtimeOnly("io.r2dbc:r2dbc-postgresql:0.8.8.RELEASE")
    runtimeOnly("org.postgresql:postgresql:42.2.23")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}


application {
    // Define the main class for the application.
    mainClass.set("com.gluttony.Application")
}

tasks.test {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
