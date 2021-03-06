package com.example.soultosoul.CudiQ.Fragments.MainFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.soultosoul.CudiQ.Auth.EmailPasswordActivity;
import com.example.soultosoul.CudiQ.Fragments.OtherFragments.MoodFragment;
import com.example.soultosoul.CudiQ.Fragments.OtherFragments.UserInfoFragment;
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel;
import com.example.soultosoul.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {
    private MainViewModel viewModel;
    private EditText email, password;
    private Button btn_signUp,btn_signIn;
    private TextView status;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_sign_up, container, false);
        mAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            UserInfoFragment userInfoFragment = new UserInfoFragment();
            replaceFragment(userInfoFragment);
        }

        email = (EditText) view.findViewById(R.id.fieldEmailUp);
        password = (EditText) view.findViewById(R.id.fieldPasswordUp);

        status = (TextView) view.findViewById(R.id.statusUp);
        btn_signIn = (Button) view.findViewById(R.id.signInButton);
        btn_signIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                SignInFragment signInFragment = new SignInFragment();
                replaceFragment(signInFragment);

            }
        });
        btn_signUp = (Button) view.findViewById(R.id.emailSignUpButton);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if (!repassword.getText().toString().equals(password.getText().toString())){
                //  Toast.makeText(getActivity(), "Password and confirm password not same. Please try again.", Toast.LENGTH_SHORT).show();
                //  return;

                String emailID = email.getText().toString();
                String paswd = password.getText().toString();
                if (emailID.isEmpty()) {
                    email.setError("Provide your Email first!");
                    email.requestFocus();
                } else if (paswd.isEmpty()) {
                    password.setError("Set your password");
                    password.requestFocus();
                }
                else if (emailID.isEmpty() && paswd.isEmpty()) {
                    //Toast.makeText(getActivity(), "Fields Empty!", Toast.LENGTH_SHORT).show();
                    System.out.println("Auth Error 1");
                } else if (!(emailID.isEmpty() && paswd.isEmpty())) {

                    mAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                System.out.println("Succes Auth");
                                UserInfoFragment userInfoFragment = new UserInfoFragment();
                                replaceFragment(userInfoFragment);
                            } else {
                               System.out.println("Auth error");
                               status.setText("Вы уже зарегистрированы");
                               status.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }}});

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
