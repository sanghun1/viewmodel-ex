package com.cos.exviewmodel;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Sign2Fragment extends Fragment {

    public static String TAG = "Sign2Fragment:";

    private MainViewModel model;

    private Button btn_pw;

    public static EditText edit_pw;

    private TextView tv_id, tv_pw, tv_email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign2, container, false);

        btn_pw = view.findViewById(R.id.btn_pw);

        edit_pw = view.findViewById(R.id.edit_pw);

        tv_id = view.findViewById(R.id.tv_id);
        tv_pw = view.findViewById(R.id.tv_pw);
        tv_email = view.findViewById(R.id.tv_email);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        btn_pw.setOnClickListener(item -> {
            Item inputItem = new Item();
            inputItem.setId(tv_id.getText().toString());
            inputItem.setPw(edit_pw.getText().toString());
            inputItem.setEmail(tv_email.getText().toString());
            model.select(inputItem);
            edit_pw.setText("");
            tv_id.setText(tv_id.getText().toString());
        });

        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            tv_id.setText(item.getId());
            tv_pw.setText(item.getPw());
            tv_email.setText(item.getEmail());
        });
    }
}