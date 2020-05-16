package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.Fragments.MainFragments.MainPageFragment;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;

import java.util.List;

public class RecBlogAdapter extends RecyclerView.Adapter<RecBlogAdapter.ViewHolder> {
    private Context context;
    private List<Blog> arrDataStories;
    private ClickListener clickListener;

    public RecBlogAdapter(List<Blog> arrDataStories, ClickListener clickListener) {
        this.arrDataStories = arrDataStories;
        this.clickListener = clickListener;
    }

    public RecBlogAdapter(Context context, List<Blog> arrDataStories, ClickListener clickListener) {
        this.context = context;
        this.arrDataStories = arrDataStories;
        this.clickListener = clickListener;
    }

    public RecBlogAdapter(Context context, List<Blog> blogs) {
        this.context = context;
        arrDataStories = blogs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_of_stories_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindItem(arrDataStories.get(position));
        holder.nextPage.setOnClickListener(v-> {
            clickListener.onClickBlog(position, arrDataStories.get(position));
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
        void onClickBlog(int position, Blog textOfList);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainText;
        View nextPage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.mainTextOfStories);
            nextPage = itemView.findViewById(R.id.cardViewKids);
        }

        private void bindItem(Blog mainTextstr) {
            mainText.setText(mainTextstr.getTitle());
        }
    }
}
