import com.majo.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("shikimori.android.library")
                apply("shikimori.android.hilt")
                apply("shikimori.compose")
            }
            dependencies {
                "implementation"(project(":common:dagger_utils"))
                "implementation"(project(":common:core"))
                "implementation"(project(":common:design_system"))
                "implementation"(project(":common:navigation"))
                "implementation"(project(":common:mvi"))

                "implementation"(libs.findLibrary("lifecycleViewModel").get())
                "implementation"(libs.findLibrary("hiltNavigation").get())
            }
        }
    }
}