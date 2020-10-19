plugins {
    kotlin("multiplatform") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.10"
    id("maven-publish")
}
group = "io.github.tschie.ktecs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}
kotlin {
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
