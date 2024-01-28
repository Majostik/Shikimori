import com.majo.Configuration
import com.majo.withVersionCatalog

plugins {
    id("convention.kapt")
}

project.withVersionCatalog { libs ->
    dependencies {
        add(Configuration.kapt, libs.daggerCompiler)
        add(Configuration.api, libs.dagger)
    }
}
