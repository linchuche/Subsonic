package github.daneren2005.dsub.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import github.daneren2005.dsub.R;
import github.daneren2005.dsub.fragments.SettingsFragment;
import github.daneren2005.dsub.util.Constants;
import github.daneren2005.dsub.util.Util;

public class SplashActivity extends Activity {
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        settings = Util.getPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        int instance = 1;
        editor.putInt(Constants.PREFERENCES_KEY_SERVER_COUNT, instance);
        // Reset set folder ID
        editor.putString(Constants.PREFERENCES_KEY_MUSIC_FOLDER_ID + instance, null);
        editor.putString(Constants.PREFERENCES_KEY_SERVER_URL + instance, "http://47.104.23.161:4533");
        editor.putString(Constants.PREFERENCES_KEY_SERVER_NAME + instance, getResources().getString(R.string.settings_server_unused));
        editor.putString(Constants.PREFERENCES_KEY_USERNAME + instance, "ccpanguin");
        editor.putString(Constants.PREFERENCES_KEY_PASSWORD + instance, "ENj40Uk2rPMvcWek3XH5GueQwoY8zU+Tj0hrMmFQJXn/");
        editor.apply();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SubsonicFragmentActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500); // 延时1秒

//        String pwd = settings.getString(Constants.PREFERENCES_KEY_PASSWORD + 2, "ccpanguin");
//        Log.d("TAG",pwd);

//        SettingsFragment.ServerSettings ss = new SettingsFragment.ServerSettings(instance);
//        serverSettings.put(String.valueOf(instance), ss);
//        ss.update();
    }

}