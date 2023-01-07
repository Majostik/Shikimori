enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
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
rootProject.name = "Shikimori"
include(":shikimori-app")
include (":common:dagger")
include (":common:android")
include (":common:common")
include (":common:android")
include (":app:animelist")
include (":common:retrofit")
include (":common:design-system")
include (":api:animelist")
includeBuild("build-logic")
include (":common:mvi")
include (":api:anime-details")
include (":app:anime-details")
include (":common:navigation")
