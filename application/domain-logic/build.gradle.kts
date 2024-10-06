plugins {
    id("com.example.kotlin")
}

group = "com.organisation.projectname"
dependencies {
    api(projects.application.domainEntity)
    implementation(projects.application.common)
}
