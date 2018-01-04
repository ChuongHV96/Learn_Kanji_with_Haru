package prm3101.group_assignment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prm3101.group_assignment.R;
import prm3101.group_assignment.util.Utils;

public class SplashActivity extends AppCompatActivity {

    protected int _splashTime = 1000;
    private SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    String allKanji = utils.readJSONdata(SplashActivity.this);
                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("All_KANJI", allKanji);
                    editor.commit();
//                    int waited = 0;
//                    while (waited < _splashTime) {
//                        sleep(100);
//                        waited += 100;
//                    }
                } catch (Exception e) {
                    // do nothing
                } finally {
                    finish();
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }
            }
        };
        splashTread.start();

    }
}