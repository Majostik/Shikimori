import com.majo.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RemoteApiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("shikimori.android.library")
                apply("shikimori.android.hilt")
                apply("shikimori.kotlinx.serialization")
            }
            dependencies {
                dependencies {
                    "implementation"(libs.findLibrary("retrofit").get())
                }
            }
        }
    }
}