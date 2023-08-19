import com.majo.Configuration
import com.majo.withVersionCatalog
import org.gradle.kotlin.dsl.configure
import com.android.build.gradle.BaseExtension

project.withVersionCatalog { libs ->
    configure<BaseExtension> {
        with(buildFeatures) {
            compose = true
        }
        with(composeOptions) {
            kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
        }
    }
    dependencies {
        add(Configuration.implementation, libs.composeActivity)
        add(Configuration.implementation, libs.composeMaterial3)
        add(Configuration.implementation, libs.composeFoundation)
        add(Configuration.implementation, libs.composeFoundationLayout)
        add(Configuration.implementation, libs.composeRuntime)
        add(Configuration.implementation, libs.composeUi)
        add(Configuration.implementation, libs.composePreview)
        add(Configuration.implementation, libs.composeConstraint)
        add(Configuration.implementation, libs.compose.navigation)
        add(Configuration.implementation, libs.coilCompose)
        add(Configuration.implementation, libs.accompanistSystemuicontroller)
    }
}
