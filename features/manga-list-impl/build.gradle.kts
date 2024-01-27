plugins {
    id("convention.android-library")
    id("convention.compose")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.manga_list.impl"
}

dependencies {
    implementation(projects.api.mangaList)
    implementation(projects.features.mangaListPublic)
    implementation(projects.common.dagger)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.mvi)
    implementation(projects.common.designSystem)
    implementation(libs.lifecycleViewModel)
    implementation(libs.hiltNavigation)
}