import com.android.build.gradle.BaseExtension
import com.majo.configureKotlin
import com.majo.withVersionCatalog
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("kotlin-android")
                apply("shikimori.android.hilt")
                apply("shikimori.spotless")
            }

            withVersionCatalog { libs ->
                configure<BaseExtension> {
                    compileSdkVersion(libs.versions.compileSdk.get().toInt())
                    defaultConfig {
                        minSdk = 23
                        targetSdk = 34
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                }
            }
            configureKotlin()
        }
    }

}