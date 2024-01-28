plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("com.squareup.anvil")
}

android {
    namespace = "com.majo.shikimori.android"
}

dependencies {
    api(libs.appcompat)
    api(libs.coreKtx)
    api(libs.activityKtx)
    api(libs.fragmentKtx)
    implementation(projects.common.anvil)
}