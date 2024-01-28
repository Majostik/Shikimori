plugins {
    alias(libs.plugins.shikimori.feature)
}

android {
    namespace = "com.majo.shikimori.manga_list.impl"
}

dependencies {
    implementation(projects.remote.mangaList)
    implementation(projects.features.mangaList.api)
}