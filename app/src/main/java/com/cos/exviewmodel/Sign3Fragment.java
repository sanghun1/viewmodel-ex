package com.cos.exviewmodel;

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
import androidx.lifecycle.ViewModelProvider;


public class Sign3Fragment extends Fragment {

    public static String TAG = "Sign3Fragment:";

    private MainViewModel model;

    private Button btn_email;

    public static EditText edit_email;

    private TextView tv_id, tv_pw, tv_email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign3, container, false);

        btn_email = view.findViewById(R.id.btn_email);

        edit_email = view.findViewById(R.id.edit_email);

        tv_id = view.findViewById(R.id.tv_id);
        tv_pw = view.findViewById(R.id.tv_pw);
        tv_email = view.findViewById(R.id.tv_email);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        btn_email.setOnClickListener(item -> {
            Item inputItem = new Item();
            inputItem.setId(tv_id.getText().toString());
            inputItem.setPw(tv_pw.getText().toString());
            inputItem.setEmail(edit_email.getText().toString());
            model.select(inputItem);
            edit_email.setText("");
        });

        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            tv_id.setText(item.getId());
            tv_pw.setText(item.getPw());
            tv_email.setText(item.getEmail());
        });
    }
}