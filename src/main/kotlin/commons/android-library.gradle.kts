package commons

import BuildAndroidConfig
import dependencies.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("kotlin-allopen")
//    id("com.vanniktech.android.junit.jacoco")
    id("com.vanniktech.dependency.graph.generator")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
        isCheckReleaseBuilds = false
    }

    packagingOptions.exclude("META-INF/main.kotlin_module")
}

//junitJacoco {
////    includeNoLocationClasses = true
//    excludes = listOf("**/extensions/NavigationExtensions*.*")
//}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Dependencies.KOTLIN)
    api(Dependencies.COROUTINES_CORE)
    api(Dependencies.COROUTINES_ANDROID)
    api(Dependencies.TIMBER)

    implementation(Dependencies.KOIN_CORE)
    implementation(Dependencies.KOIN_ANDROID)

    implementation(Dependencies.SDP)
    implementation(Dependencies.SSP)
}
