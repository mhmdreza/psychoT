package ir.nilva.azmoonyar;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import ir.nilva.azmoonyar.R;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder binder = new LocalBinder();

    public IBinder onBind( Intent arg0 ) {
        return binder;
    }

    public IBinder onUnBind( Intent arg0 ) {
        return null;
    }

    public class LocalBinder extends Binder {
        public BackgroundSoundService getServiceInstance() {
            return BackgroundSoundService.this;
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.music);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    public boolean isPlaying(){
        return player.isPlaying();
    }
    public void onStart() {
        player.start();
    }

    public void onStop() {
        player.stop();
    }
    public void onPause() {
        player.pause();

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}