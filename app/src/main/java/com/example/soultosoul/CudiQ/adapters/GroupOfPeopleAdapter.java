package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.Fragments.MainFragments.MainPageFragment;
import com.example.soultosoul.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Author: kuanyshsalyk
 * Created on 5/10/20
 */

public class GroupOfPeopleAdapter extends RecyclerView.Adapter<GroupOfPeopleAdapter.ViewHolder> {
    private Context mContext;
    private List<MainPageFragment.TypeClass> mDataList;
    private ClickListener clickListener;
    private List<Image> image;

    public GroupOfPeopleAdapter(Context context, List<MainPageFragment.TypeClass> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }

    public GroupOfPeopleAdapter(Context mContext, List<MainPageFragment.TypeClass> mDataList,
                                ClickListener clickListener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_of_people_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindItem(mDataList.get(position));
        holder.nextPage.setOnClickListener(v -> {
            clickListener.onClickGroupPeople(position, mDataList.get(position));
        });
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public interface ClickListener {
        void onClickGroupPeople(int position, MainPageFragment.TypeClass textOfList);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainText;
        Button nextPage;
        ImageView groupOfPeopleImage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.mainText);
            nextPage = itemView.findViewById(R.id.nextPage);
            groupOfPeopleImage = itemView.findViewById(R.id.groupOfPeopleImage);
        }

        private void bindItem(MainPageFragment.TypeClass mainTextstr) {
            mainText.setText(mainTextstr.getName());
            int url = mainTextstr.getImage();
            //System.out.println("REcArticleAdapter" + url);
            if (url!= 0) {
                Picasso.get()
                        .load(url)
                        .resize(0, 185)
                        .into(groupOfPeopleImage);
            }


        }
    }

}
