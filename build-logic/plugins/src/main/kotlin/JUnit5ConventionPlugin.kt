import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

open class JUnit5ConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply("org.jetbrains.kotlin.jvm")

            dependencies {
                testImplementation(platform(libs.findLibrary("junit5.bom").get()))
                testImplementation(libs.findLibrary("junit5.params").get())
                implementation(libs.findLibrary("junit5.engine").get())
                testImplementation(libs.findLibrary("mockito.core").get())
                testImplementation(libs.findLibrary("mockito.junit5").get())
            }

            tasks.withType<Test> {
                useJUnitPlatform()
                testLogging {
                    events = setOfNotNull(
                        TestLogEvent.FAILED,
                        TestLogEvent.PASSED,
                        TestLogEvent.SKIPPED
                    )
                    showStackTraces = true
                    exceptionFormat = TestExceptionFormat.FULL
                }
            }
        }
    }
}