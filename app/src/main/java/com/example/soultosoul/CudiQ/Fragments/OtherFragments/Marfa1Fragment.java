package com.example.soultosoul.CudiQ.Fragments.OtherFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.soultosoul.R;

import butterknife.BindView;
import butterknife.OnClick;


public class Marfa1Fragment extends Fragment {
    @BindView(R.id.text12a)
    TextView text1;
    @BindView(R.id.text123a)
    TextView text2;
    @BindView(R.id.text124a)
    TextView text3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marfa1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.text12a, R.id.text123a, R.id.text124a})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text12a:
                break;
            case R.id.text123a:
                break;
            case R.id.text124a:
                break;
        }
    }
}
