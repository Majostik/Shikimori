plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
    id("com.squareup.anvil")
}
android {
    namespace = "com.majo.shikimori.mangalist.impl"
}


dependencies {
    implementation(projects.api.mangaList)
    implementation(projects.features.mangaListPublic)
    implementation(projects.common.dagger)
    implementation(projects.common.anvil)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.mvi)
    implementation(projects.common.designSystem)
    implementation(libs.lifecycleViewModel)
}