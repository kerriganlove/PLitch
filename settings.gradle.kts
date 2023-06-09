pluginManagement {
    repositories {
        includeBuild("build-convention")
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PLitch"
include(":app")
include(":core:data")
include(":core:network")
