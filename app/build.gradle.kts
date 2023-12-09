import java.util.Properties
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")

}

val apikeyPropertiesFile= rootProject.file("apikeys.Properties")
val apikeyProperties = Properties()
apikeyProperties.load(apikeyPropertiesFile.inputStream())


android {
    namespace = "com.example.birdseyeview_part2"
    compileSdk = 33


    defaultConfig {
        applicationId = "com.example.birdseyeview_part2"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildFeatures {
            dataBinding = true
            viewBinding = true
            buildConfig = true
            mlModelBinding = true
        }
        buildConfigField("String", "EBIRD_API_KEY", apikeyProperties.getProperty("EBIRD_API_KEY"))
        buildConfigField("String", "MAPS_API_KEY", apikeyProperties.getProperty("MAPS_API_KEY"))
        val manifestPlaceholders = mapOf("MAPS_API_KEY: " to apikeyProperties.getProperty("MAPS_API_KEY"))
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
val retrofit_version = "2.9.0"

dependencies {
    implementation ("androidx.preference:preference:1.2.1")
    implementation ("com.google.code.gson:gson:2.9.0")

    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-storage-ktx:20.2.1")
    implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
    implementation("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation("com.google.firebase:firebase-firestore-ktx:24.8.1")
    implementation ("androidx.fragment:fragment:1.6.1")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("com.android.volley:volley:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.android.material:material:1.3.0-alpha03")
    //tensorflow dependency
    implementation ("org.tensorflow:tensorflow-lite-support:0.1.0")
    implementation ("org.tensorflow:tensorflow-lite-metadata:0.1.0")

    //gif
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.23")

    //  picasso, images library
    implementation ("com.squareup.picasso:picasso:2.71828")

    //  retrofit and gson converter
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //  coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))



    androidTestImplementation("androidx.compose:compose-bom:2023.03.00")
    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")

    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.11.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:okhttp-urlconnection")


}