import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.example.spring.kotlin")
    id("com.example.detekt")
}

group = "com.organisation.projectname"

dependencies {
    implementation(projects.application.common)
    implementation(projects.application.repository)
    implementation(projects.application.domainEntity)
}

tasks.withType<BootJar> {
    enabled = false
}
