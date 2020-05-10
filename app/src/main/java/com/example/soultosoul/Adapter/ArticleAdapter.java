package com.example.soultosoul.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.Activity.KidResultActivity;
import com.example.soultosoul.Activity.MoodActivity;
import com.example.soultosoul.Activity.ReadActivity;
import com.example.soultosoul.Entities.Article;
import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.R;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Article> articles;
    private View view;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.kid_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ViewHolder holder, int position) {
        final Article article = articles.get(position);
        System.out.println(article.getTitle()+" Adapter");
        holder.titleView.setText(article.getTitle());
        holder.textView.setText(article.getContent());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleView, textView;
        ViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.kidTitle);
            textView = (TextView) view.findViewById(R.id.kidText);
        }
    }
}