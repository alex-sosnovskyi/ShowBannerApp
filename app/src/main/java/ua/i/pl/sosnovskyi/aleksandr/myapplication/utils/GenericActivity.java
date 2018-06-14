package ua.i.pl.sosnovskyi.aleksandr.myapplication.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.utils.Launcher;


public abstract class GenericActivity extends AppCompatActivity {
    Launcher launcher = new Launcher(getSupportFragmentManager());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Launcher getLauncher() {
        return launcher;
    }
}
