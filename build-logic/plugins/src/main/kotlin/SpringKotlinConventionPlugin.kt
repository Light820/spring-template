import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

open class SpringKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.spring.dependency-management")
            pluginManager.apply("org.springframework.boot")
            pluginManager.apply("com.example.kotlin")
            pluginManager.apply("org.jetbrains.kotlin.plugin.spring")
            pluginManager.apply("org.jetbrains.kotlin.plugin.jpa")
            pluginManager.apply("org.jetbrains.kotlin.plugin.noarg")

            dependencies {
                implementation(libs.findLibrary("spring-boot-starter-web").get())
                implementation(libs.findLibrary("spring-boot-starter-data-jpa").get())
                implementation(libs.findLibrary("spring-boot-starter-security").get())
                implementation(libs.findLibrary("kotlin-reflect").get())
                testImplementation(libs.findLibrary("spring-boot-starter-test").get())
                implementation(libs.findLibrary("h2").get())
            }
        }
    }
}