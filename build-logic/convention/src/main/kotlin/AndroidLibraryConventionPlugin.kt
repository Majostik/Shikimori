import com.android.build.gradle.BaseExtension
import com.majo.withVersionCatalog
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("kotlin-android")
                apply("kotlin-parcelize")
                apply("shikimori.spotless")
            }

            withVersionCatalog {libs ->
                configure<BaseExtension> {
                    compileSdkVersion(libs.versions.compileSdk.get().toInt())
                    defaultConfig {
                        minSdk = 23
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                }
            }
        }
    }

}