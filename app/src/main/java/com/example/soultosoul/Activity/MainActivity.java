package com.example.soultosoul.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.Entities.Post;
import com.example.soultosoul.Network.NetworkService;
import com.example.soultosoul.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final TextView textView = findViewById(R.id.test);
        NetworkService.getInstance()
                .getJSONApi()
                .getBlogWithID(1)
                .enqueue(new Callback<Blog>() {
                    @Override
                    public void onResponse(@NonNull Call<Blog> call, @NonNull Response<Blog> response) {
                        Blog blog = response.body();

                        textView.append(blog.getId() + "\n");
                        textView.append(blog.getTitle() + "\n");
                        textView.append(blog.getContent() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Blog> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });

        NetworkService.getInstance()
                .getJSONApi().getAllBlogs().enqueue(new Callback<List<Blog>> (){

            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                List<Blog> blog = response.body();

                for(Blog m:blog) {
                    textView.append(m.getId() + "\n");
                    textView.append(m.getTitle() + "\n");
                    textView.append(m.getContent() + "\n");
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                textView.append("Error occurred while getting request!");
                t.printStackTrace();
            }
        });
    }




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.ic_home:
                    break;
                case R.id.ic_person:
                    Intent b = new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(b);
                    overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
            }
            return false;
        }
    };

}

