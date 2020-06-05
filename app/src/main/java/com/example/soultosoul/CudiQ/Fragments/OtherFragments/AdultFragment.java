package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecArticleAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;

public class AdultFragment extends Fragment implements RecArticleAdapter.ClickListener, View.OnClickListener {
    private MainViewModel mainViewModel;
    private RecArticleAdapter recArticleAdapter;
    private RecyclerView listRecAdult;
    private int category;
    private RecyclerView.LayoutManager layoutManager;
    private ImageButton adultHome;
    private ImageButton adultSchool;
    private ImageButton adultInternet;
    private ImageButton adultFriend;
    private ImageButton adultSelf;
    private int adultReason;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_adult, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adultHome = view.findViewById(R.id.adultHome);
        adultHome.setOnClickListener(this);

        adultSchool = view.findViewById(R.id.adultSchool);
        adultSchool.setOnClickListener(this);

        adultInternet = view.findViewById(R.id.adultInternet);
        adultInternet.setOnClickListener(this);

        adultFriend = view.findViewById(R.id.adultFriend);
        adultFriend.setOnClickListener(this);

        adultSelf = view.findViewById(R.id.adultSelf);
        adultSelf.setOnClickListener(this);

        listRecAdult = view.findViewById(R.id.listRecAdult);
        listRecAdult.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        listRecAdult.setLayoutManager(layoutManager);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        category = mainViewModel.getCategory().getValue();
        mainViewModel.getArticleByCat(category).observe(requireActivity(), articles -> {
            if (articles != null) {
                recArticleAdapter = new RecArticleAdapter(getContext(), articles, this);
                listRecAdult.setAdapter(recArticleAdapter);
            }
        });
    }

    public void getAdultReason(int probId){
        mainViewModel.getArticleByCatProb(category, probId).observe(requireActivity(), articles -> {
            if (articles != null) {
                recArticleAdapter = new RecArticleAdapter(getContext(), articles, this);
                listRecAdult.setAdapter(recArticleAdapter);
            }
        });
    }

    public void getDefault(){
        mainViewModel.getArticleByCat(category).observe(requireActivity(), articles -> {
            if (articles != null) {
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

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.adultHome:
                if(adultHome.isSelected()){
                    adultHome.setSelected(false);
                    mainViewModel.adultReason.setValue(10);
                    getDefault();
                }
                else {
                    adultHome.setSelected(true);
                    adultSchool.setSelected(false);
                    adultInternet.setSelected(false);
                    adultFriend.setSelected(false);
                    adultSelf.setSelected(false);
                    mainViewModel.adultReason.setValue(1);
                    getAdultReason(1);
                }

                break;

            case R.id.adultSchool:
                if(adultSchool.isSelected()) {
                    adultSchool.setSelected(false);
                    mainViewModel.adultReason.setValue(10);
                    getDefault();
                }
                else
                {
                    adultHome.setSelected(false);
                    adultSchool.setSelected(true);
                    adultInternet.setSelected(false);
                    adultFriend.setSelected(false);
                    adultSelf.setSelected(false);
                    mainViewModel.adultReason.setValue(2);
                    getAdultReason(2);

                }
                break;

            case R.id.adultInternet:
                if(adultInternet.isSelected()) {
                    adultInternet.setSelected(false);
                    mainViewModel.adultReason.setValue(10);
                    getDefault();
                }
                else
                {
                    adultHome.setSelected(false);
                    adultSchool.setSelected(false);
                    adultInternet.setSelected(true);
                    adultFriend.setSelected(false);
                    adultSelf.setSelected(false);
                    mainViewModel.adultReason.setValue(3);
                    getAdultReason(3);
                }
                break;

            case R.id.adultFriend:
                if(adultFriend.isSelected()) {
                    adultFriend.setSelected(false);
                    mainViewModel.adultReason.setValue(10);
                    getDefault();
                }
                else
                {
                    adultHome.setSelected(false);
                    adultSchool.setSelected(false);
                    adultInternet.setSelected(false);
                    adultFriend.setSelected(true);
                    adultSelf.setSelected(false);
                    mainViewModel.adultReason.setValue(4);
                    getAdultReason(4);
                }
                break;

            case R.id.adultSelf:
                if(adultSelf.isSelected()) {
                    adultSelf.setSelected(false);
                    mainViewModel.adultReason.setValue(10);
                    getDefault();
                }
                else
                {
                    adultHome.setSelected(false);
                    adultSchool.setSelected(false);
                    adultInternet.setSelected(false);
                    adultFriend.setSelected(false);
                    adultSelf.setSelected(true);
                    mainViewModel.adultReason.setValue(5);
                    getAdultReason(5);
                }
                break;
        }

    }
}
