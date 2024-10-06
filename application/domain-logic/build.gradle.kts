plugins {
    id("com.example.kotlin")
    id("com.example.licensee")
}

group = "com.organisation.projectname"
dependencies {
    api(projects.application.domainEntity)
    implementation(projects.application.common)
}
