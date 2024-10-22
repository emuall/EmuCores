
plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.swordfish.core.ppsspp_13"
    defaultConfig {
        missingDimensionStrategy("cores", "google")
        missingDimensionStrategy("opensource", "circle")
    }
    packagingOptions {
        doNotStrip("*/*/*_libretro_android.so")
    }
}

dependencies {
    implementation(project(":app"))
    implementation(kotlin(deps.libs.kotlin.stdlib))
}

fun getSource(): String {
    println("Dynamic features: " + gradle.startParameter.taskRequests.toString())
    val source = gradle.startParameter.taskRequests[0].args[0].replace(":lemuroid-app:assemble","").replace(":lemuroid-app:bundle","").replace("assemble","").replace("bundle","").replace("Google","").replace("Git","").replace("Debug","").replace("Release","").toLowerCase()
    return source.toString()
}
