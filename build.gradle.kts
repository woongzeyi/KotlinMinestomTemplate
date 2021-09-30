plugins {
    kotlin("jvm") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

repositories {
    mavenCentral()

    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.Minestom:Minestom:-SNAPSHOT")
}

// Sets Kotlin to target JVM 11
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

// Sets the resulting jar file to start execute from the main function
tasks.withType<Jar> {
    manifest {
        attributes(
            "Main-Class" to "ServerKt"
        )
    }
}
