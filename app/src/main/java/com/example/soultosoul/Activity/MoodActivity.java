package com.example.soultosoul.Activity;

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
        final ImageButton imageButton = (ImageButton) findViewById(R.id.mood_angry);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setSelected(!imageButton.isSelected());

                if (imageButton.isSelected()) {
                    mood = 1;
                }
            }
        });

        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.mood_curios);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton2.setSelected(!imageButton2.isSelected());

                if (imageButton2.isSelected()) {
                    mood = 2;
                }
            }
        });

        final ImageButton imageButton3 = (ImageButton) findViewById(R.id.mood_shame);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton3.setSelected(!imageButton3.isSelected());

                if (imageButton3.isSelected()) {
                    mood = 3;
                }
            }
        });

        final ImageButton imageButton4 = (ImageButton) findViewById(R.id.mood_not_sure);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton4.setSelected(!imageButton4.isSelected());

                if (imageButton4.isSelected()) {
                    mood = 4;
                }
            }
        });

        final ImageButton imageButton5 = (ImageButton) findViewById(R.id.mood_sad);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton5.setSelected(!imageButton5.isSelected());

                if (imageButton5.isSelected()) {
                    mood = 5;
                }
            }
        });
    }

    private void goToReason() {
        Button btn = (Button) findViewById(R.id.btn_to_reason);
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