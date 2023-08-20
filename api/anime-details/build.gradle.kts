plugins {
    id("convention.android-library")
    id("convention.dagger")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.retrofit)
}