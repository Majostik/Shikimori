plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
}

dependencies {
    implementation(project(":api:anime-details"))
    implementation(project(":common:dagger"))
    implementation(project(":common:android"))
    implementation(project(":common:navigation"))
    implementation(libs.glide)
    implementation(libs.coilCompose)
    implementation(project(":common:mvi"))
    implementation(libs.lifecycleViewModel)
}