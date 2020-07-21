package com.example.chetnamart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }
    private EditText registeredEmail;
    private Button btnResetPassword;
    private TextView goBack;

    private FrameLayout parentFrameLayout;

    private FirebaseAuth firebaseAuth;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        registeredEmail = view.findViewById(R.id.etProvideEmail);
        btnResetPassword = view.findViewById(R.id.btnResetPassword);
        goBack = view.findViewById(R.id.tvGoBack);

        firebaseAuth = FirebaseAuth.getInstance();

        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnResetPassword.setEnabled(false);
                btnResetPassword.setTextColor(getResources().getColor(R.color.disabledBtn));
                firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "email sent successfully!", Toast.LENGTH_LONG).show();
                                }else {
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                                }
                                btnResetPassword.setEnabled(true);
                                btnResetPassword.setTextColor(getResources().getColor(R.color.royalBlue));
                            }
                        });

            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SignUpFragment());
            }
        });

    }

    private void checkInputs(){
        if(TextUtils.isEmpty(registeredEmail.getText())){
            btnResetPassword.setEnabled(false);
            btnResetPassword.setTextColor(getResources().getColor(R.color.disabledBtn));
        }else{
            btnResetPassword.setEnabled(true);
            btnResetPassword.setTextColor(getResources().getColor(R.color.royalBlue));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}