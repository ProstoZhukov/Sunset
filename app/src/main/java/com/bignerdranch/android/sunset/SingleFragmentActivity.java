package com.bignerdranch.android.sunset;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm = getSupportFragmentManager();// sozdanie managera dlya tranzakzii
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);//sozdanie fragmente
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()//Создать новую транзакцию фрагмента, включить в нее одну операцию ad, а затем закрепить»
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
