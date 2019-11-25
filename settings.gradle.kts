rootProject.name = "air-draw"

// when running the root jib task, ignore the android subproject
if (startParameter.taskRequests.find { it.args.contains(":server:shadowJar") } == null) {
    include("common", "android", "web", "server")
} else {
    include("common", "web", "server")
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.android.application") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
            if (requested.id.id == "com.google.gms.google-services") {
                useModule("com.google.gms:google-services:${requested.version}")
            }
        }
    }
}
