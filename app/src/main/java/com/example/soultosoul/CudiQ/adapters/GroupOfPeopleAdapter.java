package com.example.soultosoul.CudiQ.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.R;

import java.util.List;


/**
 * Author: kuanyshsalyk
 * Created on 5/10/20
 */
public class GroupOfPeopleAdapter extends RecyclerView.Adapter<GroupOfPeopleAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mDataList;
    private ClickListener clickListener;

    public GroupOfPeopleAdapter(Context context, List<String> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }

    public GroupOfPeopleAdapter(Context mContext, List<String> mDataList,
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
        void onClickGroupPeople(int position, String textOfList);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainText;
        Button nextPage;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainText = itemView.findViewById(R.id.mainText);
            nextPage = itemView.findViewById(R.id.nextPage);
        }

        private void bindItem(String mainTextstr) {
            mainText.setText(mainTextstr);
        }
    }

}
