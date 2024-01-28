plugins {
   id("convention.android-library")
}
android {
   namespace = "com.majo.shikimori.mangalist.api"
}

dependencies {
   implementation(libs.compose.navigation)
}
