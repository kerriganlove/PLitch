import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


dependencies {
    implementation(libs.androidGradlePlugin)
    implementation(libs.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "plitch.androidApplication"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}