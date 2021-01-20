plugins {
    `maven-publish`
}

group = "ch.swisscypher.u14n"


tasks {
    jar {
        archiveBaseName.set(parent?.name)
        archiveAppendix.set("api")
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/swisscypher/u14n")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("api") {
            from(components["java"])
            // Include any other artifacts here, like javadocs
        }
    }
}