package fr.nohas.go4food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import fr.nohas.go4food.client.activities.ClientMenuActivity;

public class ClientOrderDriverInProgressActivity extends AppCompatActivity {
    TextView textView;
    LottieAnimationView lottieAnimationViewDriving;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_order_driver_in_progress);

        textView = findViewById(R.id.tv_commandeEnCoursDriver);
        lottieAnimationViewDriving = findViewById(R.id.lottie_delivery_riding);

        textView.animate().translationY(-1400).setDuration(7000).setStartDelay(0);
        lottieAnimationViewDriving.animate().translationX(7000).setDuration(7000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ClientOrderDriverInProgressActivity.this, ClientMenuActivity.class));
            }
        },10000);

    }
}