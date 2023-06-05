package com.kerriganlove.plitch.buildConvention

import com.android.build.api.dsl.ApplicationExtension
import kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import java.io.File

internal fun Project.android(type : ApplicationExtension.() -> Unit) {
    extensions.configure(type)
}

/**
 * 프로젝트'들' 간 Android 기본 설정은 여기서 진행.
 */
internal fun Project.setDefaultAndroid() {
    android {
        compileSdk = 33

        defaultConfig {
            minSdk = 28
            maxSdk = 33
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

/**
 * Android Compose Default Setting
 */

internal fun Project.setAndroidCompose() {
    android {
        buildFeatures.compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
        }
        // Compose 재료명세서를 통한 버전 관리
        dependencies {
            val bom = platform(libs.findLibrary("androidxComposeBom").get())
            // Bill of Materials(재료명세서) 설정
            implementation(bom)
            androidTestImplementation(bom)

            // Compose Default Implementation
            implementation(libs.findLibrary("androidxComposeUiTooling"))
            implementation(libs.findLibrary("androidxComposeUiToolingPreview"))
            implementation(libs.findLibrary("androidxComposeUiUtil"))
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = File(project.buildDir, "compose-metrics")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
        )
    }

    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = File(project.buildDir, "compose-reports")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
        )
    }
    return metricParameters.toList()
}
