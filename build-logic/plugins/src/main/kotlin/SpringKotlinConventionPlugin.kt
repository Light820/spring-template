import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

open class SpringKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("io.spring.dependency-management")
            pluginManager.apply("org.springframework.boot")
            pluginManager.apply("org.jetbrains.kotlin.jvm")

            dependencies {
                add("implementation", libs.findLibrary("spring-boot-starter").get())
                add("implementation", libs.findLibrary("spring-boot-starter-web").get())
                add("implementation", libs.findLibrary("spring-boot-starter-data-jpa").get())
                add("implementation", libs.findLibrary("spring-boot-starter-security").get())
                add("testImplementation", libs.findLibrary("spring-boot-starter-test").get())
                add("implementation", libs.findLibrary("h2").get())
                add("implementation", libs.findLibrary("kotlin-reflect").get())
            }

            tasks.named("compileKotlin") {
                doFirst {
                    val kotlinOptions = javaClass.getMethod("getKotlinOptions").invoke(this)
                    kotlinOptions.javaClass.getMethod("setJvmTarget", String::class.java).invoke(kotlinOptions, "21")
                    kotlinOptions.javaClass.getMethod("setFreeCompilerArgs", List::class.java).invoke(kotlinOptions, listOf("-Xjsr305=strict"))
                }
            }
        }
    }
}