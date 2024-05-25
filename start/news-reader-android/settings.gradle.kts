import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val properties = Properties().apply {
    val file = File("local.properties")
    if (file.exists()) {
        load(file.inputStream())
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/alvindizon/newsreaderkmp")
            credentials {
                username = properties.getProperty("github.user")
                password = properties.getProperty("github.token")
            }
        }
    }
}

rootProject.name = "NewsReader"
include(":app")
 