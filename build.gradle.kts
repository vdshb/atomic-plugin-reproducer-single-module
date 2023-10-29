plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.9.0"
}

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.22.0")
    }
}

group = "com.example"

apply(plugin = "kotlinx-atomicfu")

//atomicfu {
//    transformJvm = true
//}

kotlin {
    @Suppress("OPT_IN_USAGE")
    targetHierarchy.default()
    jvm {
        jvmToolchain(11)
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.library()
//        browser()
        nodejs()
    }
    mingwX64()
    val hostOs = System.getProperty("os.name")
    if (hostOs == "Linux") {
        linuxX64()
    }
    if (hostOs == "Mac OS X") {
        macosX64()
//        macosArm64()
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:atomicfu:0.22.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

}
