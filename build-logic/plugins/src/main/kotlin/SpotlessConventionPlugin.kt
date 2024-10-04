import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.diffplug.spotless")

            configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt", "**/*.kts")
                    ktlint("1.3.1")
                }
            }
        }
    }
}