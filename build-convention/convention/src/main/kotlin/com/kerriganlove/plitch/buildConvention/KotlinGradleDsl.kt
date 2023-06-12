import com.android.build.api.dsl.ApplicationExtension
import com.kerriganlove.plitch.buildConvention.implementation
import com.kerriganlove.plitch.buildConvention.libs
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.setAndroidKtorClient() {
    dependencies {
        // Kotlin/JVM - Android...?
        implementation(libs.findLibrary("ktorClientCore").get())
        implementation(libs.findLibrary("ktorClientOkHttp").get())
        implementation(libs.findLibrary("ktorClientJsonSerialization").get())
        implementation(libs.findLibrary("ktorClientOkHttpLoggingInterceptor").get())
    }
}

internal fun ApplicationExtension.kotlinOptions(block : KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)

}