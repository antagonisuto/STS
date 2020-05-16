package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecArticleAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KidResultFragment extends Fragment implements RecArticleAdapter.ClickListener{
    private MainViewModel mainViewModel;
    private RecArticleAdapter recArticleAdapter;
    private MutableLiveData<Integer> reasonInt;
    private int reason = 0;

    @BindView(R.id.newListKid)
    RecyclerView newListKid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result_kid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            reason =  (int) bundle.get("reasonId");
        }
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        reason = mainViewModel.getReason().getValue();
        if(reason==0){
        mainViewModel.getArticleKid().observe(requireActivity(), art -> {
                if (art != null) {
                    recArticleAdapter = new RecArticleAdapter(getContext(), art, this);
                    newListKid.setAdapter(recArticleAdapter);
                } else {
                    Log.d("Hello", "Error #12 from KidResultFragment");
                }
            });
        } else {
            mainViewModel.getArticleByCatProb(1,reason).observe(requireActivity(), artic -> {
                if(artic!=null){
                    recArticleAdapter = new RecArticleAdapter(getContext(), artic, this);
                    newListKid.setAdapter(recArticleAdapter);
                } else {
                    Log.d("Hello", "Error #13 from KidResultFragment");
                }
            });
        }
    }

    @Override
    public void onClickArticle(int position, Article article) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("article", article);
        KidReadFragment kidReadFragment = new KidReadFragment();
        kidReadFragment.setArguments(bundle);
        replaceFragment(kidReadFragment);

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
