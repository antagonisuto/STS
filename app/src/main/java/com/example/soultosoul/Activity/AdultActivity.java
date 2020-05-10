package com.example.soultosoul.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.Adapter.ArticleAdapter;
import com.example.soultosoul.Entities.Article;
import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.Network.NetworkService;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdultActivity extends AppCompatActivity {
    List<Article> articles = new ArrayList<>();
    int adult_type = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult);
        Bundle arguments = getIntent().getExtras();

        adult_type = (int) arguments.getSerializable("adult_type");

        NetworkService.getInstance()
                .getJSONApi().getArticlesByCat(adult_type).enqueue(new Callback<List<Article>>(){
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                articles = response.body();
                for (Article m:articles){
                    System.out.println(m.getTitle());
                }
                System.out.println(adult_type+" Adult Activity ");
                recView(articles);
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                System.out.println("Error occurred while getting request! #12");
                t.printStackTrace();
            }
        });

        recView(articles);
    }

    private void recView(List<Article> art) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listRec);
        // создаем адаптер
        ArticleAdapter adapter = new ArticleAdapter(this, art);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
}
