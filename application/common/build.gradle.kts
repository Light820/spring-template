plugins {
    id("com.example.kotlin")
}
group = "com.organisation.projectname"

dependencies {
    api(libs.findLibrary("arrow-core").get())
}
