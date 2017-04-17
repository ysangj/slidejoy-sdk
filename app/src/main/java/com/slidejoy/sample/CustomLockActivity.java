package com.slidejoy.sample;

import android.os.Bundle;
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
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setOnTrackingListener(new OnTrackingListener() {
			@Override
			public void onImpression(Bundle bundle) {
				printBundle(bundle);
			}

			@Override
			public void onClick(Bundle bundle) {
				printBundle(bundle);
			}
		});
	}

	void printBundle(Bundle bundle) {
		for (String key : bundle.keySet()) {
			Object value = bundle.get(key);
			Log.d(TAG, String.format("%s %s (%s)", key,
					value.toString(), value.getClass().getName()));
		}
	}

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
