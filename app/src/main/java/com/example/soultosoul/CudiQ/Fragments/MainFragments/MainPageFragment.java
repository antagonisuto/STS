package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.os.Bundle;
import android.util.Log;
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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.Fragments.OtherFragments.AdultFragment;
import com.example.soultosoul.CudiQ.Fragments.OtherFragments.MoodFragment;
import com.example.soultosoul.CudiQ.Fragments.OtherFragments.OtherFragment;
import com.example.soultosoul.CudiQ.adapters.GroupOfPeopleAdapter;
import com.example.soultosoul.CudiQ.adapters.RecBlogAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPageFragment extends Fragment implements GroupOfPeopleAdapter.ClickListener, RecBlogAdapter.ClickListener {
    @BindView(R.id.recyclerOfKids)
    RecyclerView recyclerOfKids;
    @BindView(R.id.readMoreBlog)
    Button readMoreBlog;
    @BindView(R.id.recyclerOfStory)
    RecyclerView recyclerOfStory;
    @BindView(R.id.recyclerOfTag)
    RecyclerView recyclerOfTag;


    MoreFragment more;
    FragmentTransaction fTrans;
    private GroupOfPeopleAdapter adapterForKids;
    private List<String> arrDataAboutGroup = new ArrayList<>();
    private MainViewModel viewModel;
    //private RecyclerView recyclerView;
    private RecBlogAdapter recBlogAdapter;
    //private MutableLiveData<List<Blog>> arrDataStories = new MutableLiveData<>();

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
        moreButton(view);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getAllBlogData().observe(requireActivity(), blogs -> {
            if (blogs != null) {
                recBlogAdapter = new RecBlogAdapter(getContext(), blogs, this);
                recyclerOfStory.setAdapter(recBlogAdapter);
            } else {
                Log.d("Hello", "ERROR FROM MESSAGE");
            }
        });
    }

    private void moreButton(View view) {
        more = new MoreFragment();
        fTrans = getFragmentManager().beginTransaction();
        Button button = view.findViewById(R.id.moreButtonMain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fTrans.add(R.id.frgmCont, more);
                fTrans.commit();
                button.setVisibility(View.GONE);
            }
        });

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
        if(position==0) {
            MoodFragment moodFragment = new MoodFragment();
            replaceFragment(moodFragment);
        } else {
            viewModel.category.setValue(position+1);
            AdultFragment adultFragment = new AdultFragment();
            replaceFragment(adultFragment);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }

    @Override
    public void onClickBlog(int position, Blog textOfList) {
        //Toast.makeText(getContext(), textOfList.getTitle(), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putSerializable("blog", textOfList);
        OtherFragment otherFragment = new OtherFragment();
        otherFragment.setArguments(bundle);
        replaceFragment(otherFragment);
    }
}
