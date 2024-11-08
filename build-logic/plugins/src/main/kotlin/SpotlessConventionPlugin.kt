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
                    targetExclude("build/**/*.kts")
                    val ktlintVersion = libs.findVersion("ktlint").get().toString()
                    ktlint(ktlintVersion)
                }

                json {
                    target("src/**/*.json")
                    simple()
                }

                format("toml") {
                    target("**/*.toml")
                    prettier(mapOf("prettier" to "latest", "prettier-plugin-toml" to "latest"))
                        .config(mapOf("parser" to "toml", "plugins" to listOf("prettier-plugin-toml")))
                }
            }
        }
    }
}
