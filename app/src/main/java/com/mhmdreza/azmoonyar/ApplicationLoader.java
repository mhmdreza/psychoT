package com.mhmdreza.azmoonyar;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ApplicationLoader extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANSansMobile_Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
