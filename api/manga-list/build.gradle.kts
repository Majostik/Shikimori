plugins {
    id("convention.android-library")
    id("kotlinx-serialization")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.api.manga_list"
}

dependencies {
    implementation(projects.common.retrofit)
}