package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecArticleAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;

public class AdultFragment extends Fragment implements RecArticleAdapter.ClickListener {
    private MainViewModel mainViewModel;
    private RecArticleAdapter recArticleAdapter;
    private int category;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_adult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView listRecAdult = view.findViewById(R.id.listRecAdult);
        listRecAdult.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        listRecAdult.setLayoutManager(layoutManager);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        category = mainViewModel.getCategory().getValue();
        mainViewModel.getArticleByCat(category).observe(requireActivity(), articles -> {
            if(articles!=null){
                recArticleAdapter = new RecArticleAdapter(getContext(), articles, this);
                listRecAdult.setAdapter(recArticleAdapter);
            }
        });
    }

    @Override
    public void onClickArticle(int position, Article article) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("article", article);
        AdultReadFragment adultReadFragment = new AdultReadFragment();
        adultReadFragment.setArguments(bundle);
        replaceFragment(adultReadFragment);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
