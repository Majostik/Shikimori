plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("convention.dagger")
    id("convention.compose")
}

android {
    namespace = "com.majo.shikimori"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.majo.shikimori"
        minSdk = 23
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.api.animelist)
    implementation(projects.api.animeDetails)
    implementation(projects.api.mangaList)

    implementation(projects.features.home)
    implementation(projects.features.animelistPublic)
    implementation(projects.features.animeDetailsPublic)
    implementation(projects.features.animelistImpl)
    implementation(projects.features.animeDetailsImpl)
    implementation(projects.features.mangaListPublic)
    implementation(projects.features.mangaListImpl)

    implementation(projects.common.designSystem)
    implementation(projects.common.dagger)
    implementation(projects.common.retrofit)
    implementation(projects.common.android)
    implementation(projects.common.navigation)
    implementation(projects.common.anvil)

    implementation(libs.kotlinxSerialization)
    implementation(libs.retrofit.converter.kotlinxSerialization)
    implementation(libs.okhttp.logging.interceptor)
}