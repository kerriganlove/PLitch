import java.util.*

plugins {
    id("plitch.android.application")
    id("plitch.android.hilt")
    id("plitch.kotlin.serialization")
}

android {
    namespace = "com.kerriganlove.core.network"

    buildFeatures {
        buildConfig = true
    }
}