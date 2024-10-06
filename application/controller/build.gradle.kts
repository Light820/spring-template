import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.example.spring.kotlin")
    id("com.example.licensee")
}

group = "com.organisation.projectname"

dependencies {
    implementation(projects.application.domainLogic)
    implementation(projects.application.domainEntity)
    implementation(projects.application.common)
}

tasks.withType<BootJar> {
    enabled = false
}
