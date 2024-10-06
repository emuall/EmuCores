
plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "top.aio51.play.core.genesis_plus_gx"
    defaultConfig {
        missingDimensionStrategy("cores", "google")
        missingDimensionStrategy("opensource", getSource())
    }
    packaging {
        jniLibs{
            keepDebugSymbols.add("*/*/*_libretro_android.so")
        }
    }
}

dependencies {
    implementation(project(":app"))
    implementation(kotlin(deps.libs.kotlin.stdlib))
}

fun getSource(): String {
    println("Dynamic features: " + gradle.startParameter.taskRequests.toString())
    val source = gradle.startParameter.taskRequests[0].args[0].replace(":app:assemble","").replace(":app:bundle","").replace("assemble","").replace("bundle","").replace("Google","").replace("Git","").replace("Debug","").replace("Release","").lowercase()
    return source.toString()
}
