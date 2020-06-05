package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;
import com.squareup.picasso.Picasso;

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
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.articleTitle);
            mainTextView = itemView.findViewById(R.id.articleText);
            recyclerView = itemView.findViewById(R.id.articleCard);
            imageView = itemView.findViewById(R.id.articleImage);
        }

        public void bindItem(Article article) {
            textView.setText(article.getTitle());
            String temp = article.getShortContent();
            if(temp.contains("<p>")){
                temp.replace("<p>","");
            }
            mainTextView.setText(temp+"...");
            String url = article.getImageArticle().getUrl();
            //System.out.println("REcArticleAdapter" + url);
            if (url != null) {
                Picasso.get()
                        .load(url)
                        .resize(0, 185)
                        .into(imageView);
            }

        }
    }

    public interface ClickListener {
        void onClickArticle(int position, Article article);
    }
}
