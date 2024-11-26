plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.sweetbakery2"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.example.sweetbakery2"
        minSdk = 26
        targetSdk = 35
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

    // DataBinding configuration (without 'enabled = true')
    dataBinding {
        // No need for 'enabled = true' in newer AGP versions
    }

    viewBinding{

    }


    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("com.google.firebase:firebase-firestore-ktx:24.3.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("com.google.firebase:firebase-firestore-ktx:24.3.0")

    implementation ("com.google.firebase:firebase-storage:21.0.1")  // Firebase Storage
    implementation ("com.google.firebase:firebase-firestore:24.1.1")  // Firebase Firestore
    implementation ("com.google.firebase:firebase-auth:21.1.0") // Firebase Auth (if needed for authenticated users)

    implementation ("com.google.firebase:firebase-storage:20.0.0")

    implementation ("com.google.firebase:firebase-auth:21.1.0")  // Firebase Authentication SDK
    implementation ("com.google.firebase:firebase-firestore:24.1.0")  // Firebase Firestore SDK

    // Firebase Auth dependency
    implementation ("com.google.firebase:firebase-auth:21.0.3")

    // Firebase Firestore dependency
    implementation ("com.google.firebase:firebase-firestore:24.0.3")

    // Google Play services dependency (for Google APIs)
    implementation ("com.google.android.gms:play-services-auth:20.2.0")

    implementation("androidx.recyclerview:recyclerview:1.2.0")  // RecyclerView
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Activity KTX (for viewModels delegate)
    implementation("androidx.activity:activity-ktx:1.7.2")

    // Glide dependency for image loading
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Firebase Firestore
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.0")

    // Firebase Auth and other dependencies
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-database-ktx:20.0.3")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.activity:activity:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-maps:17.0.0")
    // Firebase BOM for automatic version management
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

    // Firebase Messaging (no need to specify version if using BOM)
    implementation("com.google.firebase:firebase-messaging")
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.database)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.google.firebase:firebase-storage-ktx")
}
