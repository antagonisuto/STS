package com.example.soultosoul.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.Adapter.ArticleAdapter;
import com.example.soultosoul.Adapter.BlogAdapter;
import com.example.soultosoul.Entities.Article;
import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.Network.NetworkService;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KidResultActivity extends AppCompatActivity {
    List<Article> articles = new ArrayList<>();
    int mood = 0;
    int reason = 0;
    int kid = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle arguments = getIntent().getExtras();
        mood = (int) arguments.getSerializable("mood");
        reason = (int) arguments.getSerializable("reason");

        NetworkService.getInstance()
                .getJSONApi().getArticlesByCatMoodProb(kid, mood, reason).enqueue(new Callback<List<Article>>(){
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                articles = response.body();
                for (Article m:articles){
                    System.out.println(m.getTitle());
                }
                System.out.println(mood+" "+reason);
                recView(articles);
            }


            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                System.out.println("Error occurred while getting request! #12");
                t.printStackTrace();
            }
        });



    }

    private void recView(List<Article> art) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listKidRec);
        // создаем адаптер
        ArticleAdapter adapter = new ArticleAdapter(this, art);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
}
