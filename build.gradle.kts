import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}

group = "io.kava.template"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.merlinths:kava-core:1.0.0")
    implementation("io.github.merlinths:kava-annotations:1.0.3")

    add("ksp", "io.github.merlinths:kava-processor:1.0.1")
    add("kspTest", "io.github.merlinths:kava-processor:1.0.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)

    sourceSets {
        main {
            kotlin.srcDir("build/generated/ksp/main/kotlin")
        }

        test {
            kotlin.srcDir("build/generated/ksp/test/kotlin")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}