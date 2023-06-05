import com.android.build.api.dsl.ApplicationExtension
import com.kerriganlove.plitch.buildConvention.setAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                setAndroidCompose()
            }
        }
    }
}