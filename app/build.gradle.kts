import com.github.javaparser.printer.lexicalpreservation.Kept

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.zoptal.munzul"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zoptal.munzul"
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
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        dataBinding = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    kapt {
        generateStubs = true
    }
}

dependencies {
    val rxJavaVersion = "2.1.1"
    val nav_version = "2.5.2"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//dimens Library
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.intuit.ssp:ssp-android:1.0.6")
    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //RX Java
    implementation("io.reactivex.rxjava2:rxandroid:$rxJavaVersion")
    implementation("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    //noinspection LifecycleAnnotationProcessorWithJava8
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.7.0")
    //Retrofit
    //noinspection GradleDependency
//    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines")
//    //noinspection GradleDependency
//    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

// Retrofit 2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
    //navigation graphs
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("com.google.dagger:dagger:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")
    implementation("com.google.dagger:dagger-android:2.48")
    kapt("com.google.dagger:dagger-android-processor:2.48")
    implementation("com.google.dagger:dagger-android-support:2.48")
    //multidex
    implementation("androidx.multidex:multidex:2.0.1")
    //material library
    implementation("com.google.android.material:material:1.11.0")


    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //dimens Library
    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")

    //otp
    implementation ("com.github.rajputmukesh748:MukeshOtpView:1.0.0")

    //dot Indicator
    implementation("com.tbuonomo:dotsindicator:5.0")

    //Glide library
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    kapt ("com.github.bumptech.glide:compiler:4.11.0")
    kapt ("androidx.annotation:annotation:1.2.0-alpha01")




}