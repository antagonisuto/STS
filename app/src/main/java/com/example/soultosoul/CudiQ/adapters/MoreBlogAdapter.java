package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;

import java.util.List;

import butterknife.Optional;

public class MoreBlogAdapter extends RecyclerView.Adapter<MoreBlogAdapter.ViewHolder> {
    private Context context;
    private List<Blog> arrDataStories;
    private ClickListener clickListener;

    public MoreBlogAdapter(List<Blog> arrDataStories, ClickListener clickListener) {
        this.arrDataStories = arrDataStories;
        this.clickListener = clickListener;
    }

    public MoreBlogAdapter(Context context, List<Blog> arrDataStories, ClickListener clickListener) {
        this.context = context;
        this.arrDataStories = arrDataStories;
        this.clickListener = clickListener;
    }

    public MoreBlogAdapter(Context context, List<Blog> blogs) {
        this.context = context;
        arrDataStories = blogs;
    }

    @Optional
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_more, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindItem(arrDataStories.get(position));
        holder.nextPage.setOnClickListener(v-> {
            clickListener.onClickListBlog(position, arrDataStories.get(position));
        });
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return arrDataStories.size();
    }

    public interface ClickListener {
        void onClickListBlog(int position, Blog textOfList);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainText;
        TextView textView;
        View nextPage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.titleList);
            textView = itemView.findViewById(R.id.textList);
            nextPage = itemView.findViewById(R.id.nextPageList);
        }

        private void bindItem(Blog mainTextstr) {
            mainText.setText(mainTextstr.getTitle());
            textView.setText(mainTextstr.getShortContent());
        }
    }
}
