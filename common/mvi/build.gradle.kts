plugins {
    id("convention.android-library")
}

android {
    namespace = "com.majo.shikimori.mvi"
}

dependencies {
    implementation(libs.lifecycleViewModel)
}