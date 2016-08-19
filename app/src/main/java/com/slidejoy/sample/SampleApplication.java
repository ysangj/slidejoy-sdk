package com.slidejoy.sample;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.buzzvil.buzzscreen.sdk.BuzzScreen;

/**
 * SampleApplication.java
 *
 * @author Hovan Yoo
 */
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
