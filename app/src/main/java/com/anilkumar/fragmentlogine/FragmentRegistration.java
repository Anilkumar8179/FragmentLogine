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

public class FragmentRegistration extends Fragment {


    EditText username,password,email;
    Button Registration;
    String user,passw,emai;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

//    @SuppressLint("WrongConstant")
//    @Override
//    public void onAttach(@NonNull Context context) {
//
//        sharedPreferences = context.getSharedPreferences(user:"name",context.MODE_PRIVATE);
//         editor=sharedPreferences.edit();
//        super.onAttach(context);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.register_fragment,container,false);

        username=view.findViewById(R.id.edt_usernmae);
        password=view.findViewById(R.id.password);

        Registration=view.findViewById(R.id.register);


        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user=username.getText().toString();
                passw=password.getText().toString();
                emai=email.getText().toString();

                editor.putString("username",user);
                editor.putString("password",passw);
                editor.putString("email",emai);
                editor.apply();
                Toast.makeText(getContext(), "Registered ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
