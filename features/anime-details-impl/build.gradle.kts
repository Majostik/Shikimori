plugins {
    id("convention.android-library")
    id("convention.compose")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.anime_details.impl"
}

dependencies {
    implementation(projects.api.animeDetails)
    implementation(projects.common.dagger)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.designSystem)
    implementation(projects.common.mvi)
    implementation(projects.features.animeDetailsPublic)
    implementation(libs.lifecycleViewModel)
    implementation(libs.hiltNavigation)
}