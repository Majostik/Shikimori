plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")

}

android {
    namespace = "com.majo.shikimori.home"
}


dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.mvi)
    implementation(projects.common.designSystem)
    implementation(projects.features.animelistPublic)
    implementation(projects.features.mangaListPublic)
    implementation(libs.lifecycleViewModel)
}