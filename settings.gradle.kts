rootProject.name = "project-name"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

includeBuild("build-logic")
include("application:app")
include("application:controller")
findProject(":application:controller")?.name = "controller"
include("application:domain-entity")
findProject(":application:domain-entity")?.name = "domain-entity"
include("application:domain-logic")
findProject(":application:domain-logic")?.name = "domain-logic"
include("application:repository")
findProject(":application:repository")?.name = "repository"
include("application:remote")
findProject(":application:remote")?.name = "remote"
include("application:common")
findProject(":application:common")?.name = "common"
include("application:local")
findProject(":application:local")?.name = "local"
