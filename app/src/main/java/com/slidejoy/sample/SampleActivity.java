package com.slidejoy.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.buzzvil.buzzscreen.sdk.BuzzIntent;
import com.buzzvil.buzzscreen.sdk.BuzzOptions;
import com.buzzvil.buzzscreen.sdk.BuzzScreen;
import com.buzzvil.buzzscreen.sdk.UserProfile;

import java.util.ArrayList;
import java.util.Random;

public class SampleActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

	private View buttonStart, buttonStop, buttonLockscreen;
	private Switch switchNotificationShortcuts, switchNews, switchDefaultLockOnly;
	Random random = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

		buttonStart = findViewById(R.id.buttonStart);
		buttonStop = findViewById(R.id.buttonStop);
		buttonLockscreen = findViewById(R.id.buttonLockscreen);
		switchNotificationShortcuts = (Switch) findViewById(R.id.switchNotificationShortcuts);
		switchNews = (Switch) findViewById(R.id.switchNews);
		switchDefaultLockOnly = (Switch) findViewById(R.id.switchDefaultLockOnly);

		buttonStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserProfile profile = new UserProfile.Builder("TempUser_" + random.nextInt(100))
//						.setHmac("srLzQ9jziHy2mJH6HSRehQ==")        // Optional
//						.setBirthYear(1984)
						.setBirthday("1984-06-07")                    // Optional
						.setGender(random.nextBoolean() ? UserProfile.USER_GENDER_MALE : UserProfile.USER_GENDER_FEMALE)
						.build();
				// In order to apply options.
				onCheckedChanged(null, false);

				BuzzScreen.getInstance().setUserProfile(profile);
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
				sendBroadcast(new Intent(BuzzIntent.START_LOCK));
			}
		});

		switchNotificationShortcuts.setOnCheckedChangeListener(this);
		switchNews.setOnCheckedChangeListener(this);
		switchDefaultLockOnly.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		ArrayList<String> defLocks = new ArrayList<>();
		defLocks.add("default_lock_sample");                // You can manage default lock screens manually.
		defLocks.add("default_lock_sdk");                    // This resource is included in the SDK project.
		BuzzScreen.getInstance().setOptions(new BuzzOptions.Builder().useNews(switchNews.isChecked())
				.useNotificationShortcuts(switchNotificationShortcuts.isChecked())
				.useDefaultLockscreenOnly(switchDefaultLockOnly.isChecked())
				.setDefaultLockscreenResNames(defLocks).build());
	}
}
