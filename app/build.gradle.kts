plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.taskmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.taskmanager"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //implementation ("com.android.support:design:28.0.0")
    implementation ("com.google.android.material:material:1.7.0")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation ("com.google.firebase:firebase-auth:21.0.1")
    implementation ("com.google.firebase:firebase-database:20.0.1")
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("com.google.android.material:material:1.2.0")
    implementation ("com.google.android.material:material:1.7.0")
}