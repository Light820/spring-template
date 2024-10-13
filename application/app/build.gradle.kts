import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.example.spring.kotlin")
    id("com.example.junit5")
    id("com.example.detekt")
}

dependencies {
    implementation(projects.application.controller)
    implementation(projects.application.repository)
    implementation(projects.application.local)
    implementation(libs.findLibrary("postgres-sql").get())
}

tasks.withType<BootJar> {
    enabled = true
    mainClass = "com.organisation.projectname.ExampleApplicationKt"
}

group = "com.organisation.projectname"
