plugins {
    alias(libs.plugins.shikimori.android.application)
}

android {
    namespace = "com.majo.shikimori"
    defaultConfig {
        applicationId = "com.majo.shikimori"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.features.home)
    implementation(projects.features.mangaList.impl)
    implementation(projects.features.animeList.impl)
    implementation(projects.features.animeDetails.impl)

    implementation(projects.common.daggerUtils)
    implementation(projects.common.core)

    implementation(libs.retrofit)
    implementation(libs.kotlinxSerialization)
    implementation(libs.retrofit.converter.kotlinxSerialization)
    implementation(libs.okhttp.logging.interceptor)
}