import com.diffplug.gradle.spotless.SpotlessExtension
import com.majo.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.diffplug.spotless")
        }

        extensions.configure<SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                targetExclude("**/build/**/*.kt")
                ktlint("0.49.0")
                    .editorConfigOverride(
                        mapOf(
                            "ktlint_standard_filename" to "disabled",
                            "ktlint_standard_package-name" to "disabled",
                            "ktlint_standard_comment-wrapping" to "disabled",
                        )
                    )
            }
            format("kts") {
                target("**/*.kts")
                targetExclude("**/build/**/*.kts")
            }
            format("xml") {
                target("**/*.xml")
                targetExclude("**/build/**/*.xml")
            }
        }
    }
}