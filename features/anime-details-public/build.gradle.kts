plugins {
    id("convention.android-library")
}

android {
    namespace = "com.majo.shikimori.animedetails.api"
}


dependencies {
    implementation(libs.compose.navigation)
}
