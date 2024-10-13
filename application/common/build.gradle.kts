plugins {
    id("com.example.kotlin")
    id("com.example.licensee")
}
group = "com.organisation.projectname"

dependencies {
    api(libs.findLibrary("arrow-core").get())
}
