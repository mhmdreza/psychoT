package ir.nilva.azmoonyar;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ApplicationLoader extends MultiDexApplication {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANSans2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
