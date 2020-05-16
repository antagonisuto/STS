package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.R;

public class ReasonKidFragment extends Fragment implements View.OnClickListener {
    private MainViewModel mainViewModel;
    private Bundle bundle = new Bundle();
    private ImageButton reasonHome;
    private ImageButton reasonSchool;
    private ImageButton reasonInternet;
    private ImageButton reasonFriend;
    private ImageButton reasonSelf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reason,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Button button = view.findViewById(R.id.moodReasonKid);
        reasonHome = view.findViewById(R.id.reason_home);
        reasonHome.setOnClickListener(this);

        reasonSchool = view.findViewById(R.id.reason_school);
        reasonSchool.setOnClickListener(this);

        reasonInternet = view.findViewById(R.id.reason_internet);
        reasonInternet.setOnClickListener(this);

        reasonFriend = view.findViewById(R.id.reason_friend);
        reasonFriend.setOnClickListener(this);

        reasonSelf = view.findViewById(R.id.reason_self);
        reasonSelf.setOnClickListener(this);

        KidResultFragment kidResultFragment = new KidResultFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KidReadFragment kidReadFragment = new KidReadFragment();
                kidReadFragment.setArguments(bundle);
                replaceFragment(kidResultFragment);
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.reason_home:
                if(reasonHome.isSelected()){
                    reasonHome.setSelected(false);
                    mainViewModel.reason.setValue(0);
                }
                else {
                  reasonHome.setSelected(true);
                  reasonSchool.setSelected(false);
                  reasonInternet.setSelected(false);
                  reasonFriend.setSelected(false);
                  reasonSelf.setSelected(false);
                  //reason = 1;
                    mainViewModel.reason.setValue(1);
                }

                break;

            case R.id.reason_school:
                if(reasonSchool.isSelected()) {
                    reasonSchool.setSelected(false);
                    mainViewModel.reason.setValue(0);
                }
                else
                {
                    reasonHome.setSelected(false);
                    reasonSchool.setSelected(true);
                    reasonInternet.setSelected(false);
                    reasonFriend.setSelected(false);
                    reasonSelf.setSelected(false);
                    mainViewModel.reason.setValue(2);

                }
                break;

            case R.id.reason_internet:
                if(reasonInternet.isSelected()) {
                    reasonInternet.setSelected(false);
                    mainViewModel.reason.setValue(0);
                }
                else
                {
                    reasonHome.setSelected(false);
                    reasonSchool.setSelected(false);
                    reasonInternet.setSelected(true);
                    reasonFriend.setSelected(false);
                    reasonSelf.setSelected(false);
                    mainViewModel.reason.setValue(3);
                }
                break;

            case R.id.reason_friend:
                if(reasonFriend.isSelected()) {
                    reasonFriend.setSelected(false);
                    mainViewModel.reason.setValue(0);
                }
                else
                {
                    reasonHome.setSelected(false);
                    reasonSchool.setSelected(false);
                    reasonInternet.setSelected(false);
                    reasonFriend.setSelected(true);
                    reasonSelf.setSelected(false);
                    mainViewModel.reason.setValue(4);
                }
                break;

            case R.id.reason_self:
                if(reasonSelf.isSelected()) {
                    reasonSelf.setSelected(false);
                    mainViewModel.reason.setValue(0);
                }
                else
                {
                    reasonHome.setSelected(false);
                    reasonSchool.setSelected(false);
                    reasonInternet.setSelected(false);
                    reasonFriend.setSelected(false);
                    reasonSelf.setSelected(true);
                    mainViewModel.reason.setValue(5);
                }
                break;
        }

    }
}
