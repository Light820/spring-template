plugins {
    id("com.example.spring.kotlin")
}

group = "com.organisation.projectname"

dependencies {
    implementation(projects.application.domainLogic)
    implementation(projects.application.common)
}
