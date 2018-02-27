package com.lai.mvpdemo.mvp.simple2.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lai.mvpdemo.R;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager FMs = getSupportFragmentManager();
        FragmentTransaction MfragmentTransactions = FMs.beginTransaction();
        MfragmentTransactions.replace(R.id.main, new ComicFragment());
        MfragmentTransactions.commit();
    }
}
