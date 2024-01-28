// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version ("8.2.0") apply false
    id ("com.android.library") version ("8.2.0") apply false
    id ("org.jetbrains.kotlin.android") version ("1.9.21") apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version ("1.9.21")
    id ("com.savvasdalkitsis.module-dependency-graph") version ("0.10")
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt.android) apply false
}