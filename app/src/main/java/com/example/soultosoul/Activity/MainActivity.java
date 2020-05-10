package com.example.soultosoul.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

import android.os.Parcelable;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.Entities.Post;
import com.example.soultosoul.Network.NetworkService;
import com.example.soultosoul.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static List<Blog> blog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        goToPage();
        goToAdultPage();

        //final TextView card = findViewById(R.id.test);
        final TextView cardViewOtherBlogText1 = findViewById(R.id.cardViewOtherBlogText1);
        final TextView cardViewOtherBlogText2 = findViewById(R.id.cardViewOtherBlogText2);
        final TextView cardViewOtherBlogText3 = findViewById(R.id.cardViewOtherBlogText3);
        NetworkService.getInstance()
                .getJSONApi().getAllBlogs().enqueue(new Callback<List<Blog>> (){

            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                blog = response.body();
                final int arrsize = blog.size();
                goToPageRead(blog.get(arrsize-1));
                if(blog.size()>=3){
                    cardViewOtherBlogText1.setText(blog.get(arrsize-1).getTitle());
                    cardViewOtherBlogText2.setText(blog.get(arrsize-2).getTitle());
                    cardViewOtherBlogText3.setText(blog.get(arrsize-3).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                System.out.println("Error occurred while getting request! #12");
                t.printStackTrace();
            }
        });
    }

    //kids - 1, teenagers - 2, young people - 3, adults - 4
    private void goToAdultPage() {
        CardView cityCard2 = (CardView)findViewById(R.id.cardViewTeen);
        cityCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdultActivity.class);
                intent.putExtra("adult_type", 2);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        CardView cityCard3 = (CardView)findViewById(R.id.cardViewAdults);
        cityCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdultActivity.class);
                intent.putExtra("adult_type", 3);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        CardView cityCard4 = (CardView)findViewById(R.id.cardViewElders);
        cityCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdultActivity.class);
                intent.putExtra("adult_type", 4);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    public void goToPage() {
        CardView cityCard = (CardView)findViewById(R.id.cardViewKids);
        cityCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MoodActivity.class);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        CardView readMore = (CardView) findViewById(R.id.feed_card_other_blog1);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra(Blog.class.getSimpleName(),blog.get(blog.size()-1));
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        CardView readMore2 = (CardView) findViewById(R.id.feed_card_other_blog2);
        readMore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra(Blog.class.getSimpleName(),blog.get(blog.size()-2));
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        CardView readMore3 = (CardView) findViewById(R.id.feed_card_other_blog3);
        readMore3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra(Blog.class.getSimpleName(),blog.get(blog.size()-3));
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    public void goToPageRead(Blog blogVaule){
        final Blog blogValue = blogVaule;
        Button btnReadMoreBlog = (Button) findViewById(R.id.readMoreBlog);
        btnReadMoreBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra(Blog.class.getSimpleName(), blogValue);
                v.getContext().startActivity(intent);
                overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
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
                    Intent b = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(b);
                    overridePendingTransition( android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
                case R.id.ic_call:
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+77056864017"));
                    startActivity(intent);
            }
            return false;
        }
    };

}

