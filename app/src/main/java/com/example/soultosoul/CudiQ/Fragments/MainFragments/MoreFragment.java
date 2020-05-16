package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.Fragments.OtherFragments.OtherFragment;
import com.example.soultosoul.CudiQ.adapters.MoreBlogAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreFragment extends Fragment implements MoreBlogAdapter.ClickListener{
    private MainViewModel mainViewModel;
    private MoreBlogAdapter moreBlogAdapter;
    private RecyclerView moreListBlog;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_null, container, false);
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        moreListBlog = view.findViewById(R.id.moreListBlog);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mainViewModel.getAllBlogData().observe(requireActivity(), blog -> {
            if(blog != null) {
                System.out.println("nonNullable #125678");
                moreBlogAdapter = new MoreBlogAdapter(getContext(), blog, this);
                moreListBlog.setAdapter(moreBlogAdapter);
            }
        });

    }

    public void replaceFragment (Fragment fragment){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }

    @Override
    public void onClickListBlog(int position, Blog textOfList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("blog", textOfList);
        OtherFragment otherFragment = new OtherFragment();
        otherFragment.setArguments(bundle);
        replaceFragment(otherFragment);


    }
}
