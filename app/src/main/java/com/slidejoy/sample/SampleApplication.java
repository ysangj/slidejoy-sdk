package com.slidejoy.sample;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.buzzvil.buzzscreen.sdk.BuzzScreen;

/**
 * SampleApplication.java
 *
 * @author Hovan Yoo
 */
public class SampleApplication extends Application {

	static final String TAG = SampleApplication.class.getSimpleName();

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		BuzzScreen.getInstance().init("532421441328966", this, lockEventListener);
	}

	BuzzScreen.OnLockEventListener lockEventListener = new BuzzScreen.OnLockEventListener() {
		@Override
		public void onClick(Bundle bundle) {
			printBundle(bundle);
		}

		@Override
		public void onImpression(Bundle bundle) {
			printBundle(bundle);
		}
	};

	void printBundle(Bundle bundle) {
		for (String key : bundle.keySet()) {
			Object value = bundle.get(key);
			Log.d(TAG, String.format("%s %s (%s)", key,
					value.toString(), value.getClass().getName()));
		}
	}
}
