package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecBlogAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;

import java.util.List;

public class MessageFragment extends Fragment {
    private MainViewModel viewModel;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        textView = view.findViewById(R.id.someMessage);
        viewModel.getAllBlogData().observe(requireActivity(), blogs -> {
            if (blogs != null) {
                textView.setText(blogs.toString());
            } else {
                Log.d("Hello", "ERROR FROM MESSAGE");
            }
        });
    }
}
