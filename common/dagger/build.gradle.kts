plugins {
    id("convention.android-library")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori.dagger"
}

dependencies {
    implementation(libs.appcompat)
}