package com.example.newcatalystree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFragment extends Fragment {

    private EditText etEmail, etPass;
    private Button btSignUp;
    private FirebaseAuth myFirebaseAuth;
    private String myEmail, myPassword;

    private OnFragmentInteractionListener mListener;

    public SignUpFragment() {
        }

//    create new instance of this fragment
    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    creates new user in firebase
    private void CreateNewUser() {
        myFirebaseAuth.createUserWithEmailAndPassword(myEmail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(homeIntent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "Registration Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        myFirebaseAuth = FirebaseAuth.getInstance();
        
//        get connections to all the layout elements
        etEmail = view.findViewById(R.id.etEmailSignUp);
        etPass = view.findViewById(R.id.etPasswordSignUp);
        btSignUp = view.findViewById(R.id.btSignUp);

        etEmail.requestFocus(); // auto opens keyboard to type

//        tap sign up button
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEmail = etEmail.getText().toString().trim();
                myPassword = etPass.getText().toString().trim();

                if (TextUtils.isEmpty(myEmail)) {
                    Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(myPassword)) {
                    Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (myPassword.length() < 6) {
                    Toast.makeText(getContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                CreateNewUser();
            }
        });
        // Inflate the layout for this fragment
        return view;

    } // onCreateView


/*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
