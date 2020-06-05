package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;
import com.squareup.picasso.Picasso;

public class OtherFragment extends Fragment {

    private MainViewModel viewModel;
    private Blog blog;
    //todo for future special for MARFA

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read_adult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        if(bundle != null){
            blog = (Blog) bundle.get("blog");
        }

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        TextView textView = view.findViewById(R.id.titleRead);
        TextView mainText = view.findViewById(R.id.mainRead);
        ImageView imageRead = view.findViewById(R.id.imageRead);

        viewModel.getAllBlogData().observe(this, observe -> {
            if(observe!=null){
                textView.setText(blog.getTitle());
                mainText.setText(Html.fromHtml(blog.getContent()), TextView.BufferType.SPANNABLE);
                String url = blog.getImageArticle().getUrl();
                //System.out.println("REcArticleAdapter" + url);
                if (url != null) {
                    Picasso.get()
                            .load(url)
                            .fit()
                            .centerCrop()
                            .into(imageRead);
                }
                }

        });
    }
}
