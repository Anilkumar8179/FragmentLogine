package com.anilkumar.fragmentlogine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLogin extends Fragment  {

    EditText username,password;
    Button Login,Registration;
    CallbackFragment callbackFragment;
    String name, pass;
    SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;

String outputstring;

//    @Override
//    public void onAttach(@NonNull Context context) {
//
////        sharedPreferences = context.getSharedPreferences(username"",context.MODE_PRIVATE);
////        editor=sharedPreferences.edit();
////        super.onAttach(context);
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.logine_fragment,container,false);

        username=view.findViewById(R.id.edt_usernmae);
        password=view.findViewById(R.id.password);
        Login=view.findViewById(R.id.login);
        Registration=view.findViewById(R.id.register);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outputstring=encrpit(username.getText().toString(),password.getText().toString());



                name=username.getText().toString();
                pass=username.getText().toString();

                String uName, upass;
                uName=sharedPreferences.getString("username",null);
                upass=sharedPreferences.getString("password",null);

                if(username.equals(uName)&& pass.equals(upass)){
                    Toast.makeText(getContext(), "Login successes", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }


            }
        });


        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(callbackFragment!=null);
                callbackFragment.changeFragment();

            }
        });
        return view;
    }

    private String encrpit(String Data, String password) {


    }

    public void setCallbackFragment(CallbackFragment callbackFragment){
      this.callbackFragment =callbackFragment;
    }
}
