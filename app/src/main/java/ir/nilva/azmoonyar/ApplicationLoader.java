package ir.nilva.azmoonyar;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.multidex.MultiDexApplication;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class ApplicationLoader extends MultiDexApplication {
    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/IRANSans2.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }

}
