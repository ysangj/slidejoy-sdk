package com.slidejoy.sample;

import android.util.Log;
import com.buzzvil.buzzscreen.sdk.SimpleLockerActivity;

/**
 * CustomLockActivity.java
 * <p>
 * Created by Ben on 4/11/17.
 */
public class CustomLockActivity extends SimpleLockerActivity {

	private static final String TAG = CustomLockActivity.class.getSimpleName();

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart()");
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop()");
		super.onStop();
	}
}
