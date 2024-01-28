plugins {
    alias(libs.plugins.shikimori.android.library)
}

android {
    namespace = "com.majo.shikimori.anime_details.api"
}

dependencies {
    implementation(libs.compose.navigation)
}
