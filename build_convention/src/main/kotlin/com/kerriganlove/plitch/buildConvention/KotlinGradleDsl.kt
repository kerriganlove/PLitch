package com.kerriganlove.plitch.buildConvention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        setDefaultKotlin()
    }
}

internal fun Project.setDefaultKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}