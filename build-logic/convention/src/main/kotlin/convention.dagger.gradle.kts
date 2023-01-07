import com.majo.Configuration
import com.majo.withVersionCatalog

plugins {
    id("convention.kapt")
    id("com.squareup.anvil")
}

project.withVersionCatalog { libs ->
    dependencies {
        add(Configuration.kapt, libs.daggerCompiler)
        add(Configuration.api, libs.dagger)
    }
}
