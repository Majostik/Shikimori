import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlinGradle)
    implementation(libs.buildGradle)
    implementation(libs.spotless.gradlePlugin)
    compileOnly(libs.kspGradle)

}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "shikimori.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidApplication") {
            id = "shikimori.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "shikimori.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("compose") {
            id = "shikimori.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("kotlinxSerialization") {
            id = "shikimori.kotlinx.serialization"
            implementationClass = "KotlinxSerializationConventionPlugin"
        }
        register("feature") {
            id = "shikimori.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("remoteApi") {
            id = "shikimori.remote.api"
            implementationClass = "RemoteApiConventionPlugin"
        }
        register("spotless") {
            id = "shikimori.spotless"
            implementationClass = "SpotlessPlugin"
        }
    }
}