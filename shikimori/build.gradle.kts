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

    implementation(project(":api:animelist"))
    implementation(project(":app:animelist"))

    implementation(project(":common:dagger"))
    implementation(project(":common:retrofit"))
    implementation(project(":common:android"))
}
//