plugins {
    id("convention.android-library")
}

android {
    namespace = "com.majo.shikimori.animelist.api"
}


dependencies {
    implementation(libs.compose.navigation)
}
