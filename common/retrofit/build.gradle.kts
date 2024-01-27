plugins {
    id("convention.android-library")
}

android {
    namespace = "com.majo.shikimori.retrofit"
}

dependencies {
    api(libs.retrofit)
    api(libs.kotlinxSerialization)
    implementation(libs.hilt)
}