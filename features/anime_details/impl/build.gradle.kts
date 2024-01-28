plugins {
    id("convention.android-library")
    id("convention.compose")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.anime_details.impl"
}

dependencies {
    implementation(projects.remote.animeDetails)
    implementation(projects.common.dagger)
    implementation(projects.common.core)
    implementation(projects.common.navigation)
    implementation(projects.common.designSystem)
    implementation(projects.common.mvi)

    implementation(projects.features.animeDetails.api)

    implementation(libs.lifecycleViewModel)
    implementation(libs.hiltNavigation)
}