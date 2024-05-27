plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.junka.core.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(projects.core.domain)

    implementation(libs.androidx.core.ktx)

    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)

    implementation(libs.logging.interceptor)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    testImplementation(projects.core.testing)
    testImplementation(libs.junit)
}