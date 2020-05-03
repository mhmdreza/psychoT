package ir.nilva.azmoonyar;

import androidx.multidex.MultiDexApplication;

import com.evernote.android.job.JobManager;
import ir.nilva.azmoonyar.R;
import ir.nilva.azmoonyar.webservice.pref.WebservicePrefSetting;
import ir.nilva.azmoonyar.logic.MyJobCreator;

import ir.nilva.azmoonyar.logic.MyJobCreator;
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
