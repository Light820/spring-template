plugins {
    `kotlin-dsl`
}

group = "com.example"

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