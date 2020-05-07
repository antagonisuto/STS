package com.example.soultosoul.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.soultosoul.R;

public class ReasonActivity extends AppCompatActivity {
    int reason = 0;
    int mood = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        Bundle arguments = getIntent().getExtras();
        mood = (int) arguments.getSerializable("mood");



        final ImageButton imageButton = (ImageButton) findViewById(R.id.reason_card1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setSelected(!imageButton.isSelected());

                if (imageButton.isSelected()) {
                    reason = 1;
                }
            }
        });

        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.reason_card2);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setSelected(!imageButton1.isSelected());

                if (imageButton1.isSelected()) {
                    reason = 2;
                }
            }
        });

        Button btn = (Button) findViewById(R.id.btn_to_kid_result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KidResultActivity.class);
                intent.putExtra("mood", mood);
                intent.putExtra("reason", reason);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }
}
