import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import io.gitlab.arturbosch.detekt.report.ReportMergeTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(DetektPlugin::class.java)

            configure<DetektExtension> {
                basePath = projectDir.path
                config.setFrom("${rootProject.rootDir}/detekt.yml")
            }

            tasks.register<ReportMergeTask>("reportMerge") {
                output.set(rootProject.layout.buildDirectory.file("reports/detekt/project-report.sarif"))
                input.from(tasks.withType<Detekt>().map { it.sarifReportFile })
            }

            subprojects {
                tasks.withType<Detekt> {
                    reports.sarif.required.set(true)
                    finalizedBy("reportMerge")
                }
            }
        }
    }
}
