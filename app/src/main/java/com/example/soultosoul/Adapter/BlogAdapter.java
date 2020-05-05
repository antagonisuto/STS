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

import com.example.soultosoul.Activity.MoodActivity;
import com.example.soultosoul.Activity.ReadActivity;
import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.R;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Blog> blogs;
    private View view;

    public BlogAdapter(Context context, List<Blog> blogs) {
        this.blogs = blogs;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public BlogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = inflater.inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogAdapter.ViewHolder holder, int position) {
        final Blog blog = blogs.get(position);
        //holder.imageView.setImageResource(blog.getImage());
        holder.titleView.setText(blog.getTitle());
        holder.textView.setText(blog.getContent());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra(Blog.class.getSimpleName(),blog);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView imageView;
        final TextView titleView, textView;
        ViewHolder(View view){
            super(view);
            //imageView = (ImageView)view.findViewById(R.id.image);
            titleView = (TextView) view.findViewById(R.id.titleList);
            textView = (TextView) view.findViewById(R.id.textList);
        }
    }
}