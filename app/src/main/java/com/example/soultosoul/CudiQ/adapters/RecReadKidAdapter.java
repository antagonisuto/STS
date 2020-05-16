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

public class RecReadKidAdapter extends RecyclerView.Adapter<RecReadKidAdapter.ViewHolder> {
    private Context context;
    private List<Article> articles;
    private ClickListener clickListener;

    public RecReadKidAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    public RecReadKidAdapter(Context context, List<Article> articles, ClickListener clickListener) {
        this.context = context;
        this.articles = articles;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_read_kids, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(position==articles.size()-1){
            holder.bindItemAndButton(articles.get(position));
        }
        holder.bindItem(articles.get(position));
       // holder.
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView mainTextView;
        View readKidButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.readKidTitle);
            mainTextView = itemView.findViewById(R.id.readKidText);
            readKidButton = itemView.findViewById(R.id.readKidButton);
        }

        public void bindItem(Article article) {
            textView.setText(article.getTitle());
            mainTextView.setText(article.getContent());
            //System.out.println(article.getContent()+" adapter");

        }

        public void bindItemAndButton(Article article) {
            textView.setText(article.getTitle());
            mainTextView.setText(article.getContent());
            readKidButton.setVisibility(View.VISIBLE);
            //System.out.println(article.getContent()+" adapter");

        }
    }

    public void setOnClickListener(RecReadKidAdapter.ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClickReadKid(int position, Article article);
    }
}
