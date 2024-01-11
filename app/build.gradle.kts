plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.yusufarisoy.enuyguncase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yusufarisoy.enuyguncase"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.fragment)
    implementation(Libs.constraintLayout)
    // Hilt
    implementation(Libs.hiltAndroid)
    implementation(Libs.legacySupport)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    kapt(Libs.hiltAndroidCompiler)
    // Lifecycle
    implementation(Libs.lifecycleCommon)
    implementation(Libs.lifecycleRunTime)
    implementation(Libs.lifecycleViewModel)
    // Rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)
    // Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    // Navigation Component
    implementation(Libs.navigationUi)
    implementation(Libs.navigationFragment)
    // Gson
    implementation(Libs.gson)
    // Glide
    implementation(Libs.glide)
    // Test
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.espressoCore)
}