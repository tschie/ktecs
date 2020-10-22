plugins {
    kotlin("multiplatform") version "1.4.10"
    id("maven-publish")
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.4.10.2")
    }
}

if (!project.plugins.hasPlugin("org.jetbrains.dokka")) {
    project.plugins.apply("org.jetbrains.dokka")
}

group = "io.github.tschie.ktecs"
version = "0.0.1-SNAPSHOT"

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
        val commonMain by getting
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/tschie/ktecs")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}
