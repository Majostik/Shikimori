plugins {
    alias(libs.plugins.shikimori.feature)
}

android {
    namespace = "com.majo.shikimori.anime_details.impl"
}

dependencies {
    implementation(projects.remote.animeDetails)
    implementation(projects.features.animeDetails.api)
}