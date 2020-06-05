package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.CudiQ.adapters.RecBlogAdapter;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MessageFragment extends Fragment {
    private MainViewModel viewModel;
    private TextView textView;
    private static int SIGN_IN_CODE = 1;
    private RelativeLayout messageFragment;
    //private FirebaseListAdapter<Message> adapter;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message1, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        //messageFragment = (RelativeLayout) view.findViewById(R.id.messageFragment);

//        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
//            SignInFragment signInFragment = new SignInFragment();
//            replaceFragment(signInFragment);
//        } else {
//            displayAllMessages();
//        }

    }

    private void displayAllMessages() {

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
