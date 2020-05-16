package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;

import java.util.List;

public class RecArticleAdapter extends RecyclerView.Adapter<RecArticleAdapter.ViewHolder> {
    private Context context;
    private List<Article> articles;
    private ClickListener clickListener;

    public RecArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    public RecArticleAdapter(Context context, List<Article> articles, ClickListener clickListener) {
        this.context = context;
        this.articles = articles;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_of_articles,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.bindItem(articles.get(position));
            holder.recyclerView.setOnClickListener(v -> {
                clickListener.onClickArticle(position, articles.get(position));
            });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView mainTextView;
        View recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.articleTitle);
            mainTextView = itemView.findViewById(R.id.articleText);
            recyclerView = itemView.findViewById(R.id.articleCard);
        }

        public void bindItem(Article article) {
            textView.setText(article.getTitle());
            mainTextView.setText(article.getShortContent());

        }
    }

    public interface ClickListener {
        void onClickArticle(int position, Article article);
    }
}
