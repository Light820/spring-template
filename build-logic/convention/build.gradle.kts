plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(projects.common)
}

gradlePlugin {
    plugins {
        register("com.example.spring-kotlin") {
            id = "com.example.spring.kotlin"
            implementationClass = "SpringKotlinConventionPlugin"
        }
    }
}