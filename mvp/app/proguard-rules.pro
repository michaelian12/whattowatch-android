# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Dagger
#   https://github.com/google/dagger/blob/master/java/dagger/android/proguard.cfg
-dontwarn com.google.errorprone.annotations.**

# Retrofit 2.X
#   https://github.com/krschultz/android-proguard-snippets/blob/master/libraries/proguard-square-retrofit2.pro
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# OkHttp3
#   https://github.com/krschultz/android-proguard-snippets/blob/master/libraries/proguard-square-okhttp3.pro
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# Realm
#   Proguard Configuration for Realm (http://realm.io)
#   For detailed discussion see: https://groups.google.com/forum/#!topic/realm-java/umqKCc50JGU
#   Additionally you need to keep your Realm Model classes as well
#   For example:
#   -keep class com.yourcompany.realm.** { *; }

-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class *
-dontwarn javax.**
-dontwarn io.realm.**

# Fresco
#   https://github.com/facebook/fresco/blob/master/fbcore/proguard-fresco.pro
#   Keep our interfaces so they can be used by other ProGuard rules.
#   See http://sourceforge.net/p/proguard/bugs/466/
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
-keep,allowobfuscation @interface com.facebook.soloader.DoNotOptimize

#   Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

#   Do not strip any method/class that is annotated with @DoNotOptimize
-keep @com.facebook.soloader.DoNotOptimize class *
-keepclassmembers class * {
    @com.facebook.soloader.DoNotOptimize *;
}

#   Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontwarn com.facebook.infer.**

-keep class com.michaelagustian.whattowatch.base.** { *; }
-keep class com.michaelagustian.whattowatch.data.** { *; }
-keep class com.michaelagustian.whattowatch.di.** { *; }
-keep class com.michaelagustian.whattowatch.features.** { *; }
-keep class com.michaelagustian.whattowatch.model.** { *; }

-keep class com.michaelagustian.whattowatch.model.Movie.** { *; }