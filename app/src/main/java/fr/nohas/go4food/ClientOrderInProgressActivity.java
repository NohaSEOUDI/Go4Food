package fr.nohas.go4food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ClientOrderInProgressActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_order_in_progress);
        textView = findViewById(R.id.tv_commandeEnCours);
        lottieAnimationView = findViewById(R.id.lottie);

        textView.animate().translationY(-1400).setDuration(7000).setStartDelay(0);
        lottieAnimationView.animate().translationX(7000).setDuration(7000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ClientOrderInProgressActivity.this, ClientOrderDriverInProgressActivity.class));
            }
        },10000);

    }
}