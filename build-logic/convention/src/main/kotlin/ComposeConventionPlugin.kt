import com.android.build.gradle.BaseExtension
import com.majo.libs
import com.majo.withVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            withVersionCatalog {libs ->
                configure<BaseExtension> {
                    with(buildFeatures) {
                        compose = true
                    }
                    with(composeOptions) {
                        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
                    }
                }
            }

            dependencies {
                "implementation"(libs.findLibrary("composeActivity").get())
                "implementation"(libs.findLibrary("composeMaterial3").get())
                "implementation"(libs.findLibrary("composeFoundation").get())
                "implementation"(libs.findLibrary("composeFoundationLayout").get())
                "implementation"(libs.findLibrary("composeRuntime").get())
                "implementation"(libs.findLibrary("composeUi").get())
                "implementation"(libs.findLibrary("composePreview").get())
                "implementation"(libs.findLibrary("composeConstraint").get())
                "implementation"(libs.findLibrary("compose.navigation").get())
                "implementation"(libs.findLibrary("coilCompose").get())
                "implementation"(libs.findLibrary("accompanistSystemuicontroller").get())
            }
        }
    }
}