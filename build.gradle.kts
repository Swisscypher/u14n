plugins {

    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"

    id("com.github.johnrengelman.shadow") version "4.0.4"
    id("net.minecrell.licenser") version "0.4.1"
    id("com.palantir.git-version") version "0.12.3"
}

group = "ch.swisscypher.u14n"

val gitVersion: groovy.lang.Closure<String> by extra
version = gitVersion()

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "net.minecrell.licenser")

    repositories {
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
        maven { url = uri("https://libraries.minecraft.net/") }
    }

    version = gitVersion()

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