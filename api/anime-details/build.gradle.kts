plugins {
    id("convention.android-library")
    id("convention.dagger")
}

dependencies {
    implementation(project(":common:retrofit"))
}