# Buzzscreen SDK for slidejoy publishers

- Buzzvil's library for integrating BuzzScreen with Android apps.
- Requires Android version 4.1 (API level 16) or newer.

### 1. Add library

- Add to build.gradle:

```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://dl.bintray.com/buzzvil/maven/' }
    }
}


dependencies {
    compile("com.buzzvil.buzzscreen:sdk:+")
}

```


### 2. Application class

- Add `BuzzScreen.getInstance().init("APP_KEY", this)` to onCreate in your Application class.
- Don't use multi threading or call from outside of onCreate() because SDK needs the application context at the first time.

```java
public class SampleApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		BuzzScreen.getInstance().init("APP_KEY", this);
	}
}
```

### 3. Activity class

* Provide UserProfile and BuzzOptions to SDK.
* Call activate(), then SDK will start a service and show lockscreen.

#### Set UserProfile

- UserID should be provided.
- Birth Year / Birthday / Gender / Hmac

```java
UserProfile profile = new UserProfile.Builder("TempUser_" + random.nextInt(100))
	.setBirthYear(1970 + +random.nextInt(20))
	.setGender(random.nextBoolean() ? UserProfile.USER_GENDER_MALE : UserProfile.USER_GENDER_FEMALE)
	.setHmac("ABCDE")
	.setBirthday("1984-06-07")
	.build();
						
BuzzScreen.getInstance().setUserProfile(profile);
```

#### Set BuzzOptions

- Use News
- Use Notification and Shortcuts
- Default lock images resources / Use default lock only
	
```java
ArrayList<String> defLocks = new ArrayList<>();
defLocks.add("default_lock_sample");    // You can manage default lock screens manually.
defLocks.add("default_lock_sdk");        //which is included in the SDK project.
BuzzScreen.getInstance().setOptions(new BuzzOptions.Builder().useNews(switchNews.isChecked())
	.useNotificationShortcuts(switchNotificationShortcuts.isChecked())
	.setDefaultLockscreenResNames(defLocks).build());
	.useDefaultLockscreenOnly(switchDefaultLockOnly.isChecked())
						
```

#### Start lock screen service

```java
BuzzScreen.getInstance().activate();
```
