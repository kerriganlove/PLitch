import com.android.build.api.dsl.ApplicationExtension
import com.kerriganlove.plitch.buildConvention.implementation
import com.kerriganlove.plitch.buildConvention.libs
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.setKtorClient() {
    dependencies {
        implementation(libs.findLibrary("ktorClientCore"))
        implementation(libs.findLibrary("ktorClientOkHttp"))
        implementation(libs.findLibrary("ktorClientJsonSerialization"))
    }
}

internal fun ApplicationExtension.kotlinOptions(block : KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)

}