# slidejoy-sdk


## Requirements

### SampleApplication

- MultiDex.install(this)
- BuzzScreen.getInstance().init("APP_KEY", this);
~~~~

public class SampleApplication extends Application {

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		BuzzScreen.getInstance().init("APP_KEY", this);
	}
}

	
~~~~

### SampleActivity

#### Set UserProfile

- UserID should be provided.
- Birth Year / Birthday / Gender / Hmac

~~~~
				UserProfile profile = new UserProfile.Builder("TempUser_" + random.nextInt(100))
						.setBirthYear(1970 + +random.nextInt(20))
						.setGender(random.nextBoolean() ? UserProfile.USER_GENDER_MALE : UserProfile.USER_GENDER_FEMALE)
						.setHmac("ABCDE")
						.setBirthday("1984-06-07")
						.build();
						
				BuzzScreen.getInstance().setUserProfile(profile);
~~~~

#### Set BuzzOptions

- Use News
- Use Notification and Shortcuts
- Default lock images resources / Use default lock only
	
~~~~
				ArrayList<String> defLocks = new ArrayList<>();
				defLocks.add("default_lock_sample");    // You can manage default lock screens manually.
				defLocks.add("default_lock_sdk");        //which is included in the SDK project.
				BuzzScreen.getInstance().setOptions(new BuzzOptions.Builder().useNews(switchNews.isChecked())
						.useNotificationShortcuts(switchNotificationShortcuts.isChecked())
						.setDefaultLockscreenResNames(defLocks).build());
						.useDefaultLockscreenOnly(switchDefaultLockOnly.isChecked())
						
~~~~

#### Start lock screen service

~~~~
				BuzzScreen.getInstance().activate();
~~~~