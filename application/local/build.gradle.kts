plugins {
    id("com.example.spring.kotlin")
}

group = "com.organisation.projectname"


dependencies {
    implementation(projects.application.common)
    implementation(projects.application.repository)
    implementation(projects.application.domainEntity)
}
