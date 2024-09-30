import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider

fun DependencyHandler.implementation(dependency: Provider<MinimalExternalModuleDependency>) {
    add("implementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: Provider<MinimalExternalModuleDependency>) {
    add("testImplementation", dependency)
}

fun DependencyHandler.runtimeOnly(dependency: Provider<MinimalExternalModuleDependency>) {
    add("runtimeOnly", dependency)
}

fun DependencyHandler.testRuntimeOnly(dependency: Provider<MinimalExternalModuleDependency>) {
    add("restRuntimeOnly", dependency)
}

fun DependencyHandler.api(dependency: Provider<MinimalExternalModuleDependency>) {
    add("api", dependency)
}