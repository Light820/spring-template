plugins {
    id("com.example.spring.kotlin")
    id("com.example.junit5")
}

dependencies {
    implementation(projects.application.controller)
}

group = "com.example"