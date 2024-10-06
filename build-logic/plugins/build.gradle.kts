plugins {
    `kotlin-dsl`
}

group = "com.example"

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(projects.common)
    implementation(libs.spotless)
    implementation(libs.licensee)
}

gradlePlugin {
    plugins {
        register("com.example.spring-kotlin") {
            id = "com.example.spring.kotlin"
            implementationClass = "SpringKotlinConventionPlugin"
        }
    }

    plugins {
        register("com.example.junit5") {
            id = "com.example.junit5"
            implementationClass = "JUnit5ConventionPlugin"
        }
    }

    plugins {
        register("com.example.kotlin") {
            id = "com.example.kotlin"
            implementationClass = "KotlinConventionPlugin"
        }
    }

    plugins {
        register("com.example.licensee") {
            id = "com.example.licensee"
            implementationClass = "LicenseeConventionPlugin"
        }
    }

    plugins {
        register("com.example.spotless") {
            id = "com.example.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}
