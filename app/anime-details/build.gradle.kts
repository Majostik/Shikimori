plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
}

dependencies {
    implementation(projects.api.animeDetails)
    implementation(projects.common.dagger)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.designSystem)
    implementation(projects.common.mvi)
    implementation(libs.lifecycleViewModel)
    implementation(libs.glide)
    implementation(libs.coilCompose)
}