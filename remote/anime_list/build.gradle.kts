plugins {
    id("convention.android-library")
    id("kotlinx-serialization")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.api.anime_list"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlinxSerialization)
}