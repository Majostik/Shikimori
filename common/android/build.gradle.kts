plugins {
    id("convention.android-library")
    id("convention.dagger")
}

dependencies {
    api(libs.appcompat)
    api(libs.coreKtx)
    api(libs.lifecycleLivedataKtx)
    api(libs.activityKtx)
    api(libs.fragmentKtx)
    implementation(projects.common.dagger)
}