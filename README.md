# slidejoy-sdk

### SampleApplication
	
	
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
		BuzzScreen.getInstance().init("532421441328966", this);
	}
}

	
~~~~

### SampleActivity

	
~~~~

public class SampleActivity extends Activity {

	//...
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//...

		buttonStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserProfile profile = new UserProfile.Builder("TempUser_" + random.nextInt(100))
						.setBirthYear(1970 + +random.nextInt(20))
						.setGender(random.nextBoolean() ? UserProfile.USER_GENDER_MALE : UserProfile.USER_GENDER_FEMALE)
						.setHmac("ABCDE")
						.build();

				BuzzScreen.getInstance().setUserProfile(profile);

				ArrayList<String> defLocks = new ArrayList<>();
				defLocks.add("default_lock_sample");    // You can manage default lock screens manually.
				defLocks.add("default_lock_sdk");        //which is included in the SDK project.
				BuzzScreen.getInstance().setOptions(new BuzzOptions.Builder().useNews(switchNews.isChecked())
						.useNotificationShortcuts(switchNotificationShortcuts.isChecked())
						.setDefaultLockscreenResNames(defLocks).build());
				BuzzScreen.getInstance().activate();
			}
		});

		buttonStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BuzzScreen.getInstance().deactivate();
			}
		});

		buttonLockscreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sendBroadcast(new Intent(SlideIntent.START_LOCK));
			}
		});
	}
}
	
~~~~
