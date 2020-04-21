package in.socialdistance.teamvision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private Animation slideup;
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide title bar
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        // make full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setStatusBarTransparent();
        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.logo_splash);
        slideup = AnimationUtils.loadAnimation(this,R.anim.slide_in_up);

        logo.setAnimation(slideup);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent a = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(a);
                        finish();
                    }
                },3000);
    }

    private void setStatusBarTransparent(){
        if (Build.VERSION.SDK_INT>-21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
