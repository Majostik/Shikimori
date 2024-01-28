plugins {
    id("convention.android-library")
    id("convention.dagger")
}

android {
    namespace = "com.majo.shikimori.android"
}

dependencies {
    api(libs.appcompat)
    api(libs.coreKtx)
    api(libs.activityKtx)
    api(libs.fragmentKtx)
}