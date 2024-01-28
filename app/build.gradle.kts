plugins {
    id("com.android.application")
    id("kotlin-android")
    alias(libs.plugins.shikimori.android.hilt)
}

android {
    namespace = "com.majo.shikimori"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.majo.shikimori"
        minSdk = 23
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(projects.remote.animeList)
    implementation(projects.remote.animeDetails)
    implementation(projects.remote.mangaList)

    implementation(projects.features.home)
    implementation(projects.features.mangaList.api)
    implementation(projects.features.mangaList.impl)
    implementation(projects.features.animeList.api)
    implementation(projects.features.animeList.impl)
    implementation(projects.features.animeDetails.api)
    implementation(projects.features.animeDetails.impl)

    implementation(projects.common.designSystem)
    implementation(projects.common.dagger)
    implementation(projects.common.core)
    implementation(projects.common.navigation)

    implementation(libs.retrofit)
    implementation(libs.kotlinxSerialization)
    implementation(libs.retrofit.converter.kotlinxSerialization)
    implementation(libs.okhttp.logging.interceptor)
}