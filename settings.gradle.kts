enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
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
includeBuild("build-logic")
include(":app")
include(":common:dagger")
include(":common:core")
include(":common:design_system")
include(":common:mvi")
include(":common:navigation")
include(":features:home")
include(":remote:anime_list")
include(":features:anime_list:api")
include(":features:anime_list:impl")
include(":remote:anime_details")
include(":features:anime_details:api")
include(":features:anime_details:impl")
include(":remote:manga_list")
include(":features:manga_list:api")
include(":features:manga_list:impl")
