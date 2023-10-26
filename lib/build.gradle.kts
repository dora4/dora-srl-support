plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

android {
    namespace = "dora.lifecycle.srl"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.github.dora4:dora:1.1.40")
    val refreshVersion = "2.0.6"
    api("io.github.scwang90:refresh-layout-kernel:$refreshVersion")
    api("io.github.scwang90:refresh-header-classics:$refreshVersion")
    api("io.github.scwang90:refresh-footer-classics:$refreshVersion")
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["release"])
                groupId = "com.github.dora4"
                artifactId = "dora-srl-support"
                version = "1.0"
            }
        }
    }
}