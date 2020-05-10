package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.GroupOfPeopleAdapter;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPageFragment extends Fragment implements GroupOfPeopleAdapter.ClickListener {
    @BindView(R.id.recyclerOfKids)
    RecyclerView recyclerOfKids;
    @BindView(R.id.readMoreBlog)
    Button readMoreBlog;
    @BindView(R.id.recyclerOfStory)
    RecyclerView recyclerOfStory;
    @BindView(R.id.recyclerOfTag)
    RecyclerView recyclerOfTag;

    private GroupOfPeopleAdapter adapterForKids;
    private List<String> arrDataAboutGroup = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initData();
        initAdapters();
        initViews();
    }

    private void initData() {
        //todo в будущем можешь брать данные с бэкенда
        arrDataAboutGroup.add("Дети: 3 - 10 лет");
        arrDataAboutGroup.add("Подростки: 11 - 17 лет");
        arrDataAboutGroup.add("Молодые люди: 18 - 29 лет");
        arrDataAboutGroup.add("Взрослые: 30+ лет");
        arrDataAboutGroup.add("ВЕТЕРАНЫ");
    }

    private void initAdapters() {
        adapterForKids = new GroupOfPeopleAdapter(getContext(), arrDataAboutGroup, this);
    }

    private void initViews() {
        //тут посмотри на менеджера в xml файле или можешь присвоить ее сдесь
        recyclerOfKids.setAdapter(adapterForKids);
    }

    @Override
    public void onClickGroupPeople(int position, String textOfList) {
        //todo here you can move to other fragment it is sample
        Toast.makeText(getContext(), textOfList, Toast.LENGTH_SHORT).show();
//        replaceFragment(null); вместо нулла напишешь фрагмент в который надо переходить
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
