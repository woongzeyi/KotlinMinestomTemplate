/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/6.9.1/samples
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions.jvmTarget = "11"

repositories {
    mavenCentral()
    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.Minestom:Minestom:-SNAPSHOT")
}

tasks.withType<Jar> {
    manifest {
        attributes(
            "Main-Class" to "ServerKt"
        )
    }
}
