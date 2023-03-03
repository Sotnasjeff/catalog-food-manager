val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kodein_version: String by project
val log4j2_version: String by project
val slf4j_version: String by project
val disruptor_version: String by project
val prometheus_version: String by project
val jackson_datatype_version: String by project

plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.4"
}

group = "com.manager.food.catalog"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://mvnrepository.com/artifact/io.ktor/ktor-server-locations")
    }
}

dependencies {
    //Core
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    //DI
    implementation("org.kodein.di:kodein-di-generic-jvm:$kodein_version")

    //Ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
    implementation("io.ktor:ktor-server-locations:$ktor_version")
    implementation("io.ktor:ktor-server-status-pages:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-auto-head-response:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-serialization-jackson:$ktor_version")

    //Serializer
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson_datatype_version")

    //Logs
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2_version")
    implementation("org.slf4j:slf4j-api:$slf4j_version")
    implementation("org.apache.logging.log4j:log4j-core:$log4j2_version")
    implementation("com.lmax:disruptor:$disruptor_version")

    //Observability
    implementation("io.ktor:ktor-server-metrics-micrometer:$ktor_version")
    implementation("io.micrometer:micrometer-registry-prometheus:$prometheus_version")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}