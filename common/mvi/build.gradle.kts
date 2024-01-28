plugins {
    alias(libs.plugins.shikimori.android.library)
}

android {
    namespace = "com.majo.shikimori.mvi"
}

dependencies {
    implementation(libs.lifecycleViewModel)
}