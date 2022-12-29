import com.majo.withVersionCatalog
import org.gradle.kotlin.dsl.configure
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
}

project.withVersionCatalog { libs ->
    configure<BaseExtension> {
        compileSdkVersion(libs.versions.compileSdk.get().toInt())
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}
