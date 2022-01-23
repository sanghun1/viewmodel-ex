package com.cos.exviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SignFragment signFragment;
    private Sign2Fragment sign2Fragment;
    private Sign3Fragment sign3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signButton = findViewById(R.id.btn_1);
        Button sign2Button = findViewById(R.id.btn_2);
        Button sign3Button = findViewById(R.id.btn_3);

        signFragment = new SignFragment();
        sign2Fragment = new Sign2Fragment();
        sign3Fragment = new Sign3Fragment();

        signButton.setOnClickListener(View -> changeFragment(signFragment));
        sign2Button.setOnClickListener(View -> changeFragment(sign2Fragment));
        sign3Button.setOnClickListener(View -> changeFragment(sign3Fragment));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, signFragment, SignFragment.TAG).commit();
        }
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}