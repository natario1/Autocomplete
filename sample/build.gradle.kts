plugins {
    id("com.android.application")
}

android {
    setCompileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)

    defaultConfig {
        applicationId = "com.otaliastudios.sample"
        setMinSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        setTargetSdkVersion(rootProject.extra["targetSdkVersion"] as Int)
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation(project(":autocomplete"))
}
