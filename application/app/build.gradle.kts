plugins {
    id("com.example.spring.kotlin")
    id("com.example.junit5")
}

dependencies {
    implementation(projects.application.controller)
    implementation(projects.application.repository)
    implementation(projects.application.local)
}
group = "com.organisation.projectname"
