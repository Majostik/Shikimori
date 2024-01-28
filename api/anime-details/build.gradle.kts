plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("kotlinx-serialization")
    id("com.squareup.anvil")
}

android {
    namespace = "com.majo.shikimori.api.animedetails"
}


dependencies {
    implementation(projects.common.anvil)
    implementation(projects.common.retrofit)
}