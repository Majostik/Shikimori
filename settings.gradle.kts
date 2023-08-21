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
include (":features:animelist-impl")
include (":common:retrofit")
include (":common:design-system")
include (":api:animelist")
includeBuild("build-logic")
include (":common:mvi")
include (":api:anime-details")
include (":features:anime-details-impl")
include (":common:navigation")
include(":features")
include(":features:home")
include(":features:animelist-public")
include(":features:anime-details-public")
include(":api:manga-list")
include(":features:manga-list-public")
include(":features:manga-list-impl")
include(":common:anvil")
