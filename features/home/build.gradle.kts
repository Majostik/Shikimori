plugins {
    id("convention.android-library")
    id("convention.compose")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.home"
}

dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.core)
    implementation(projects.common.navigation)
    implementation(projects.common.mvi)
    implementation(projects.common.designSystem)
    implementation(projects.features.animeList.api)
    implementation(projects.features.mangaList.api)
    
    implementation(libs.lifecycleViewModel)
    implementation(libs.hiltNavigation)
}