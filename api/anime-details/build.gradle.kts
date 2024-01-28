plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("kotlinx-serialization")
}

android {
    namespace = "com.majo.shikimori.api.animedetails"
}


dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.retrofit)
}