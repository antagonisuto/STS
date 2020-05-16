package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecReadKidAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

public class KidReadFragment extends Fragment implements RecReadKidAdapter.ClickListener{
    private MainViewModel mainViewModel;
    private List<String> lst;
    private Article article;
    private RecReadKidAdapter recReadKidAdapter;
    public int i;
    List<Article> articles_temp = new ArrayList<>();
    private  RecyclerView recyclerView;
    private MutableLiveData<List<Article>> halei;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_read_kid, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            article = (Article) bundle.get("article");
        }
        recyclerView = view.findViewById(R.id.readKidRec);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        mainViewModel.getArticleById(article.getId()).observe(requireActivity(), observe -> {
            if (observe != null) {
                splitArticle(observe);
            }
        });
    }

    private void splitArticle(Article tempArr) {
        String sample = tempArr.getContent();
        lst = new ArrayList<>();
        if(sample!=null) {
            for (String regal : tempArr.getContent().split("</div>")) {
                for (String s : regal.split("<br/>")) {
                    if (s.contains("<div>"))
                    {
                        s = s.replace("<div>", "");
                    };

                    lst.add(s);
                }
            }
        }

        for (int i=0; i<lst.size()-1; i++){
            articles_temp.add(new Article(tempArr.getId(),lst.get(i),lst.get(i+1)));
            recReadKidAdapter = new RecReadKidAdapter(getContext(), articles_temp);
            recyclerView.setAdapter(recReadKidAdapter);
            i++;
        }

    }

    @Override
    public void onClickReadKid(int position, Article article) {

    }
}
