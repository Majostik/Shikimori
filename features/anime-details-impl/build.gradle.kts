plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
}

android {
    namespace = "com.majo.shikimori.animedetails.impl"
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
}