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
    mavenLocal()
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
                implementation("io.github.tschie.ktecs:ktecs-core:1.0-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(npm("gl-matrix", "^3.3.0"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
