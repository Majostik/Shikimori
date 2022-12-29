import com.majo.Configuration
import com.majo.withVersionCatalog
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("kotlin-android")
    id("kotlin-kapt")
}

project.withVersionCatalog { libs ->
    dependencies {
        add(Configuration.kapt, libs.kotlinBom)
    }
}
