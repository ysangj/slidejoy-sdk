

-keep class com.slidejoy.** { *; }
-keepclassmembers class com.slidejoy.** {
    <fields>;
    <methods>;
}

-keep class com.buzzvil.** { *; }
-keepclassmembers class com.buzzvil.** {
    <fields>;
    <methods>;
}

-keep class com.hovans.** { *; }
-keepclassmembers public class com.hovans.** {
    <fields>;
    <methods>;
}

#AA - start

-keep class org.androidannotations.api.**
-keepclassmembers class org.androidannotations.api.** {
    <fields>;
    <methods>;
}

-keep interface org.androidannotations.api.** { *; }
-dontwarn org.androidannotations.api.**

#AA - end

#Google Play Services - start

-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

##---------------Begin: proguard configuration for Gson  ----------
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson  ----------


##---------------Begin: proguard configuration for Facebook  ----------

-dontwarn com.facebook.**
-keep class com.facebook.** { *; }
-keepclassmembers class com.facebook.** {
    <fields>;
    <methods>;
}
-keep class bolts.** { *; }
-keep interface bolts.** { *; }

##---------------End: proguard configuration for Facebook  ----------

##---------------Begin: proguard configuration for Glide  ----------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
##---------------End: proguard configuration for Glide  ----------

##---------------Begin: proguard configuration for TapJoy  ----------
-keep class com.tapjoy.** { *; }
-keepclassmembers class com.tapjoy.** {
    <fields>;
    <methods>;
}
##---------------End: proguard configuration for TapJoy  ----------

##---------------Begin: proguard configuration for MAT  ----------
-keep class com.mobileapptracker.** { *; }
-keepclassmembernames class com.mobileapptracker.** {
    <fields>;
    <methods>;
}
##---------------End: proguard configuration for MAT  ----------

##---------------Begin: proguard configuration for Support V7  ----------
-keepattributes **
# Allow obfuscation of android.support.v7.internal.view.menu.**
# to avoid problem on Samsung 4.2.2 devices with appcompat v21
# see https://code.google.com/p/android/issues/detail?id=78377
#-keep class !android.support.v7.internal.view.menu.**,android.support.** {*;}
#-keepclassmembers class android.support.v7.** {
#    <methods>;
#}
##---------------End: proguard configuration for Support V7  ----------

##---------------Begin: EventBus  ----------
-keepclassmembers class ** {
    public void onEvent*(**);
}

# Only required if you use AsyncExecutor
-keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}
##---------------End: EventBus  ----------

##---------------Begin: Yahoo  ----------
-keep class com.flurry.** { *; }
-dontwarn com.flurry.**
-keepnames @com.google.android.gms.common.annotation.KeepName class *

-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

#If you are using the Google Mobile Ads SDK, add the following:
# Preserve GMS ads classes
-keep class com.google.android.gms.** { *;
}
-dontwarn com.google.android.gms.**

##---------------End: Yahoo  ----------

##---------------Begin: proguard configuration for HttpClient  ----------
-keep class cz.msebera.** { *; }
-dontwarn cz.msebera.**
-keepclassmembers class cz.msebera.** {
    <fields>;
    <methods>;
}
##---------------End: proguard configuration for HttpClient  ----------

##---------------Begin: proguard configuration for AdsNative  ----------
-keep class com.adsnative.** { *; }
-dontwarn com.adsnative.**
##---------------End: proguard configuration for AdsNative  ----------

##---------------Begin: PubNative  ----------
-keep class net.pubnative.** { *; }
##---------------End: PubNative  ----------

##---------------Begin: proguard configuration for OutBrain  ----------
-keep class com.outbrain.** { *; }
-dontwarn com.outbrain.**
-keepclassmembers class com.outbrain.** {
    <fields>;
    <methods>;
}
##---------------End: proguard configuration for OutBrain  ----------