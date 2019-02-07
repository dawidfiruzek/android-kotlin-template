object Versions {
    const val compileSdk = {{ cookiecutter.target_sdk }}
    const val minSdk = {{ cookiecutter.min_sdk }}
    const val targetSdk = {{ cookiecutter.target_sdk }}
    const val gradle = "3.1.3"
    const val kotlin = "1.2.30"
    const val support = "27.1.1"
    const val junit = "4.12"
    const val testRunner = "1.0.2"
    const val expresso = "3.0.2"
    const val mockito = "2.16.0"
    const val fabric = "1.+"
    const val crashlytics = "2.9.1"
    const val timber = "4.6.1"
    const val leakCanary = "1.5.4"
    const val dagger2 = "2.14.1"
    const val rxAndroid = "2.0.2"
    const val rxJava = "2.1.11"
    const val retrofit = "2.4.0"
    const val stetho = "1.5.0"
    const val constraintLayout = "1.1.2"
    const val lifecycle = "1.1.1"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabric = "io.fabric.tools:gradle:${Versions.fabric}"
}

object Libs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    const val supportAppcompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val supportRecycler = "com.android.support:recyclerview-v7:${Versions.support}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    const val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    const val dagger2Android = "com.google.dagger:dagger-android:${Versions.dagger2}"
    const val dagger2AndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2}"
    const val dagger2AndroidCompiler = "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoNetwork = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val kotlinReflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.expresso}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val archTesting = "android.arch.core:core-testing:${Versions.lifecycle}"
}
