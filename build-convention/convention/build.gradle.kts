import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.kerriganlove.plitch.buildConvention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}


dependencies {
    compileOnly(libs.androidGradlePlugin)
    compileOnly(libs.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "plitch.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = "plitch.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("kotlinSerialization") {
            id = "plitch.kotlin.serialization"
            implementationClass = "KotlinSerializationConventionPlugin"
        }
    }
}