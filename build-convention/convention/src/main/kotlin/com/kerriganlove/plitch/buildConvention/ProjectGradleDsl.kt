package com.kerriganlove.plitch.buildConvention

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import java.util.Optional

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun DependencyHandlerScope.implementation(
    artifact : Any
) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.androidTestImplementation(
    artifact : Any
) {
    add("androidTestImplementation", artifact)
}

internal fun DependencyHandlerScope.kapt(
    artifact : Any
) {
    add("kapt",artifact)
}
