plugins {
    id("convention.android-library")
    id("convention.dagger")
}

dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.retrofit)
}