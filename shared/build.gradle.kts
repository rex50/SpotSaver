plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.mutekt.core)
            }

            // For including generated classes in source
            kotlin.srcDirs("build/generated/ksp/metadata/commonMain/kotlin")
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecyle)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

// MuteKt file generation
dependencies {
    add("kspCommonMainMetadata", libs.mutekt.codegen)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

android {
    namespace = "com.spot.saver"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}
