plugins {
   id("convention.android-library")
   alias(libs.plugins.shikimori.android.hilt)
}

android {
   namespace = "com.majo.shikimori.manga_list.api"
}


dependencies {
   implementation(libs.compose.navigation)
   implementation(projects.common.navigation)
}
