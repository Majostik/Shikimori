plugins {
    alias(libs.plugins.shikimori.android.library)
}

android {
    namespace = "com.majo.shikimori.core"
}

dependencies {
    implementation(libs.hilt)
}