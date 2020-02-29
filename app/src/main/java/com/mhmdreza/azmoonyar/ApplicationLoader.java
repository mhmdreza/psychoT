package com.mhmdreza.azmoonyar;

import androidx.multidex.MultiDexApplication;

import com.evernote.android.job.JobManager;
import com.mhmdreza.azmoonyar.webservice.pref.WebservicePrefSetting;
import com.mhmdreza.azmoonyar.logic.MyJobCreator;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ApplicationLoader extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANSans2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        JobManager.create(this).addJobCreator(new MyJobCreator());

        WebservicePrefSetting.Companion.getInstance(getApplicationContext());

    }
}
