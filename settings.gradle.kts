pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "GMA"
include(":app")
include(":core:data")
include(":core:domain")
include(":core:presentation:designsystem")
include(":core:presentation:ui")
include(":core:testing")
include(":feature:character")
include(":feature:character:presentation")