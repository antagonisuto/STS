package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.text.Html;
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
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;
import com.squareup.picasso.Picasso;

public class AdultReadFragment extends Fragment {
    private MainViewModel mainViewModel;
    private Article article;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_read_adult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        TextView textView = view.findViewById(R.id.titleRead);
        TextView mainText = view.findViewById(R.id.mainRead);
        ImageView imageRead = view.findViewById(R.id.imageRead);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            article = (Article) bundle.get("article");
        }

        mainViewModel.getArticleById(article.getId()).observe(requireActivity(), observe -> {
            if (observe != null) {
                textView.setText(observe.getTitle());
                mainText.setText(Html.fromHtml(observe.getContent()), TextView.BufferType.SPANNABLE);
                String url = article.getImageArticle().getUrl();
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
