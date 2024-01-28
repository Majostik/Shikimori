plugins {
    alias(libs.plugins.shikimori.feature)
}

android {
    namespace = "com.majo.shikimori.anime_list.impl"
}

dependencies {
    implementation(projects.remote.animeList)
    implementation(projects.features.animeList.api)
    implementation(projects.features.animeDetails.api)
}