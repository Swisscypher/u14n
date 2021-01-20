import java.io.ByteArrayOutputStream

plugins {

    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"

    id("com.github.johnrengelman.shadow") version "4.0.4"
    id("net.minecrell.licenser") version "0.4.1"
}

group = "ch.swisscypher.u14n"

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "net.minecrell.licenser")

    repositories {
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
        maven { url = uri("https://libraries.minecraft.net/") }
    }

    fun determineVersion(): String {
        val byteOut = ByteArrayOutputStream()
        project.exec {
            commandLine("git", "describe", "--tags", "--first-parent")
            standardOutput = byteOut
        }
        try {
            project.exec {
                commandLine("git", "diff", "--exit-code", "--quiet")
            }
        } catch (e: Exception) {
            return String(byteOut.toByteArray()).replace("\\s".toRegex(), "") + ".dirty"
        }

        return String(byteOut.toByteArray()).replace("\\s".toRegex(), "")
    }

    version = determineVersion()

    dependencies {
        implementation(kotlin("stdlib"))
        implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version = "1.0.1")
        compileOnly(group = "com.mojang", name = "authlib", version = "1.5.21")
        compileOnly(group = "org.spigotmc", name = "spigot-api", version = "1.8.8-R0.1-SNAPSHOT")
        compileOnly(group = "org.bukkit", name = "bukkit", version = "1.8.8-R0.1-SNAPSHOT")
        compileOnly(group = "net.md-5", name = "bungeecord-api", version = "1.16-R0.3")
    }

    license {
        header = rootProject.file("HEADER")
        include("**/*.kt")

        newLine = true
    }

    tasks {
        jar {
            from("../LICENSE")
        }
    }
}

dependencies {
    implementation(project(":api"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    processResources {
        from("src/main/resources") {
            include("plugin.yml")
            include("bungee.yml")
            expand(project.properties)
        }
    }
}