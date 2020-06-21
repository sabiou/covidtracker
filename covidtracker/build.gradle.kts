plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    defaultConfig {
        applicationId = "dev.farouk.covidtracker"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }


    // Required for AR because it includes a library built with Java 8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }
}

dependencies {
    api(platform(project(":dependencies")))
    kapt(platform(project(":dependencies")))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Dagger Hilt
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_VIEWMODEL)
    androidTestImplementation(Libs.HILT_TESTING)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)
    kaptAndroidTest(Libs.HILT_COMPILER)
    kaptAndroidTest(Libs.ANDROIDX_HILT_COMPILER)

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CONSTRAINT_LAYOUT)
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.EXT_JUNIT)
    androidTestImplementation(Libs.ESPRESSO_CORE)

    // Google Gson
    implementation(Libs.GSON)

}