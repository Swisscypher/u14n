plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "ch.swisscypher.u14n"
version = "0.1-SNAPSHOT"

allprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        compileOnly(group = "org.spigotmc", name = "spigot-api", version = "1.8.8-R0.1-SNAPSHOT")
        compileOnly(group = "org.bukkit", name = "bukkit", version = "1.8.8-R0.1-SNAPSHOT")
        compileOnly(group = "net.md-5", name = "bungeecord-api", version = "1.16-R0.3")
    }
}

dependencies {
    implementation(project(":api"))
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