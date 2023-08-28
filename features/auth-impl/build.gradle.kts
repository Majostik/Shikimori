plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
}

dependencies {
    implementation(projects.api.auth)
    implementation(projects.features.authPublic)
    implementation(projects.common.dagger)
    implementation(projects.common.anvil)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.mvi)
    implementation(projects.common.designSystem)
    implementation(libs.lifecycleViewModel)
}