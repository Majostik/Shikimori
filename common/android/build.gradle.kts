plugins {
    id("convention.android-library")
}

android {
    namespace = "com.majo.shikimori.android"
}

dependencies {
    api(libs.appcompat)
    api(libs.coreKtx)
    api(libs.activityKtx)
    api(libs.fragmentKtx)
    implementation(libs.hilt)
}