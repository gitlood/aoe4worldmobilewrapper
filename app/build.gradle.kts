plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    `maven-publish`
}

android {
    namespace = "com.example.aoe4worldmobilewrapper"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aoe4worldmobilewrapper"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.aoe4worldmobilewrapper.CustomTestRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
          //  from(components["default"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/gitlood/aoe4worldmobilewrapper")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kaptAndroidTest(libs.hilt.android.compiler)
    implementation(libs.gson)
    implementation(libs.converter.gson)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.coroutines.android.test)
}

tasks.register("printComponents") {
    doLast {
        println("Available components:")
        components.forEach { component ->
            println(component.name)
        }
    }
}