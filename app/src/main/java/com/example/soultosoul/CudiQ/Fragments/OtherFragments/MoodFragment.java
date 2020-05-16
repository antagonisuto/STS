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

public class MoodFragment extends Fragment implements View.OnClickListener{

    private ReasonKidFragment reasonKidFragment;
    private MainViewModel mainViewModel;
    private ImageButton moodAngry;
    private  ImageButton moodCurious;
    private ImageButton moodShame;
    private ImageButton moodSad;
    private ImageButton moodNotSure;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mood, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Button button = view.findViewById(R.id.btnMood);

        moodAngry = view.findViewById(R.id.mood_angry);
        moodAngry.setOnClickListener(this);

        moodCurious = view.findViewById(R.id.mood_curios);
        moodCurious.setOnClickListener(this);

        moodShame = view.findViewById(R.id.mood_shame);
        moodShame.setOnClickListener(this);

        moodSad = view.findViewById(R.id.mood_sad);
        moodSad.setOnClickListener(this);

        moodNotSure = view.findViewById(R.id.mood_not_sure);
        moodNotSure.setOnClickListener(this);


        reasonKidFragment = new ReasonKidFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(reasonKidFragment);
            }
        });

    }

    public void onClick(View v) {

        switch(v.getId()){

            case R.id.mood_angry:
                if(moodAngry.isSelected())
                    moodAngry.setSelected(false);
                else {
                    moodAngry.setSelected(true);
                    moodCurious.setSelected(false);
                    moodNotSure.setSelected(false);
                    moodSad.setSelected(false);
                    moodShame.setSelected(false);
                }

                break;

            case R.id.mood_curios:
                if(moodCurious.isSelected())
                    moodCurious.setSelected(false);
                else
                {
                    moodAngry.setSelected(false);
                    moodCurious.setSelected(true);
                    moodNotSure.setSelected(false);
                    moodSad.setSelected(false);
                    moodShame.setSelected(false);
                }
                break;

            case R.id.mood_not_sure:
                if(moodNotSure.isSelected())
                    moodNotSure.setSelected(false);
                else
                    {
                        moodAngry.setSelected(false);
                        moodCurious.setSelected(false);
                        moodNotSure.setSelected(true);
                        moodSad.setSelected(false);
                        moodShame.setSelected(false);
                     }
                break;

            case R.id.mood_sad:
                if(moodSad.isSelected())
                    moodSad.setSelected(false);
                else
                    {
                        moodAngry.setSelected(false);
                        moodCurious.setSelected(false);
                        moodNotSure.setSelected(false);
                        moodSad.setSelected(true);
                        moodShame.setSelected(false);
                    }
                break;

            case R.id.mood_shame:
                if(moodShame.isSelected())
                    moodShame.setSelected(false);
                else
                    {
                        moodAngry.setSelected(false);
                        moodCurious.setSelected(false);
                        moodNotSure.setSelected(false);
                        moodSad.setSelected(false);
                        moodShame.setSelected(true);
                    }
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
