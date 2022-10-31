plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

//without this, project won't compile
//android {
//    compileSdk = 0
//}

androidComponents {
    finalizeDsl {
        it.namespace = "com.example.namespace"
        it.compileSdk = 32

        it.defaultConfig {
            applicationId = "com.example.testapp"
            minSdk = 23
            targetSdk = 32
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        it.buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(it.getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
        it.compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}