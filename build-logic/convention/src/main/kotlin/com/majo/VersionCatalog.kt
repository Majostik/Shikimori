package com.majo

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * workaround to make version catalog accessible in convention plugins
 * https://github.com/gradle/gradle/issues/15383
 */
fun Project.withVersionCatalog(block: (libs: LibrariesForLibs) -> Unit) {
    if (project.name != "gradle-kotlin-dsl-accessors") {
        val libs = the<LibrariesForLibs>()
        block.invoke(libs)
    }
}
fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

