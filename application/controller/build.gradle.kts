import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.example.spring.kotlin")
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
