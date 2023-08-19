plugins {
   id("convention.android-library")
    id("convention.dagger")
    id("convention.compose")
}

dependencies {
    implementation(projects.common.dagger)
    implementation(projects.common.android)
}