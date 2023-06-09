import com.kerriganlove.plitch.buildConvention.implementation
import com.kerriganlove.plitch.buildConvention.kapt
import com.kerriganlove.plitch.buildConvention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }
            dependencies {
                implementation(libs.findLibrary("hiltAndroid").get())
                kapt(libs.findLibrary("hiltAndroidCompiler").get())
            }

        }
    }
}