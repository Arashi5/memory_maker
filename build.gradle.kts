import com.google.protobuf.gradle.*

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val javaVersion = "1.8"
val protobufVersion = "3.17.3"
val grpcVersion = "1.39.0"
val grpcKotlinVersion = "1.1.0"


plugins {
    application
    id("com.google.protobuf") version "0.8.17"
    kotlin("jvm") version "1.5.21"
}

group = "maker.memory"
version = "0.0.1"

application {
    mainClass.set("maker_memory.ApplicationKt")
}
val mainClassName = "mypackage.Hello"
repositories {
    mavenCentral()
    mavenLocal()
    google()
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("build/generated/source/proto/main/grpc", "build/generated/source/proto/main/java"))
        }
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("src/main/kotlin")
            kotlin.srcDir("build/generated/source/proto/main/grpckt")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.javalin:javalin:3.10.0")

    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.grpc:grpc-kotlin-stub:${grpcKotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("com.google.protobuf:protobuf-java:${protobufVersion}")
    implementation("com.google.protobuf:protobuf-java-util:${protobufVersion}")
    runtimeOnly("io.grpc:grpc-netty:${grpcVersion}")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    implementation("io.grpc:grpc-services:${grpcVersion}")
    implementation("com.google.guava:guava:30.1.1-jre")

    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.ktor:ktor-html-builder:$ktor_version")
    implementation("io.ktor:ktor-freemarker:$ktor_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")

    implementation ("io.github.microutils:kotlin-logging:1.12.5")
}

java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}


tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersion
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.suppressWarnings = true
}


protobuf {

    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:${protobufVersion}"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
        // Specify protoc to generate using our grpc kotlin plugin
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${grpcKotlinVersion}:jdk7@jar"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}