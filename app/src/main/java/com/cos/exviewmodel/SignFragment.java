package com.cos.exviewmodel;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignFragment extends Fragment {

    public static String TAG = "SignFragment:";

    private MainViewModel model;

    private Button btn_id;

    private EditText edit_id;

    private TextView tv_id, tv_pw, tv_email;

    public static SignFragment newInstance() {
        return new SignFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_fragment, container, false);

        btn_id = view.findViewById(R.id.btn_id);

        edit_id = view.findViewById(R.id.edit_id);

        tv_id = view.findViewById(R.id.tv_id);
        tv_pw = view.findViewById(R.id.tv_pw);
        tv_email = view.findViewById(R.id.tv_email);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        btn_id.setOnClickListener(item -> {
            Item inputItem = new Item();
            inputItem.setId(edit_id.getText().toString());
            inputItem.setPw(tv_pw.getText().toString());
            inputItem.setEmail(tv_email.getText().toString());
            model.select(inputItem);
            edit_id.setText("");
        });

        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            tv_id.setText(item.getId());
            tv_pw.setText(item.getPw());
            tv_email.setText(item.getEmail());
        });
    }
}