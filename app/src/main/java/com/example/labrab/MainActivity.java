package com.example.labrab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String COUNTER1_KEY = "counter1";
    private static final String COUNTER2_KEY = "counter2";
    private Integer counter1 = 0;
    private Integer counter2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            counter1 = savedInstanceState.getInt(COUNTER1_KEY, 0);
            counter2 = savedInstanceState.getInt(COUNTER2_KEY, 0);
        }
        updateCountersOnScreen();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER1_KEY, counter1);
        outState.putInt(COUNTER2_KEY, counter2);
    }
    public void onClickButton(View view) {
        counter1++;
        updateCountersOnScreen();
    }
    public void onClickButton1(View view) {
        counter2++;
        updateCountersOnScreen();
    }
    private void updateCountersOnScreen() {
        TextView textCounter1 = findViewById(R.id.ballone);
        TextView textCounter2 = findViewById(R.id.balltwo);
        textCounter1.setText(counter1.toString());
        textCounter2.setText(counter2.toString());
    }
}