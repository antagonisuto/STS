package com.example.soultosoul.MarfaQ.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soultosoul.R;

public class MoodActivity extends AppCompatActivity {

    int mood = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        chooseMoods();
        goToReason();
    }

    private void chooseMoods() {
        final ImageButton imageButton = findViewById(R.id.mood_card1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setSelected(!imageButton.isSelected());

                if (imageButton.isSelected()) {
                    mood = 1;
                }
            }
        });

        final ImageButton imageButton2 = findViewById(R.id.mood_card2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton2.setSelected(!imageButton2.isSelected());

                if (imageButton2.isSelected()) {
                    mood = 2;
                }
            }
        });

        final ImageButton imageButton3 = findViewById(R.id.mood_card3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton3.setSelected(!imageButton3.isSelected());

                if (imageButton3.isSelected()) {
                    mood = 3;
                }
            }
        });
    }

    private void goToReason() {
        Button btn = findViewById(R.id.btn_to_reason);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReasonActivity.class);
                intent.putExtra("mood", mood);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }
}