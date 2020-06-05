package com.example.soultosoul.CudiQ.Fragments.MainFragments;

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

import com.example.soultosoul.CudiQ.Fragments.OtherFragments.UserInfoFragment;
import com.example.soultosoul.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInFragment extends Fragment {
    private EditText email, password;
    private Button btnSignIn, btnSignUp;
    private TextView statusIn;
    private FirebaseAuth mAuth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sign_in, container, false);
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
        email = (EditText) view.findViewById(R.id.fieldEmail);
        password = (EditText) view.findViewById(R.id.fieldPassword);
        btnSignIn = (Button) view.findViewById(R.id.emailSignInButton);
        statusIn = (TextView) view.findViewById(R.id.statusIn);
        btnSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String emailID = email.getText().toString();
                String passwrd = password.getText().toString();
                if (emailID.isEmpty()) {
                    email.setError("Provide your Email first!");
                    email.requestFocus();
                } else if (passwrd.isEmpty()) {
                    password.setError("Set your password");
                    password.requestFocus();
                }else if (emailID.isEmpty() && passwrd.isEmpty()) {
                    //Toast.makeText(getActivity(), "Fields Empty!", Toast.LENGTH_SHORT).show();
                    System.out.println("Auth Error 1");
                } else if (!(emailID.isEmpty() && passwrd.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(emailID,passwrd).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                System.out.println("Success In");
                                UserInfoFragment userInfoFragment = new UserInfoFragment();
                                replaceFragment(userInfoFragment);
                            } else {
                                System.out.println("In Error 2");
                            }
                        }
                    });
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment)
                .addToBackStack(getTag())
                .commit();
    }
}
