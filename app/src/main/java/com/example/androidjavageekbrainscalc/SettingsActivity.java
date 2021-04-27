package com.example.androidjavageekbrainscalc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setToolbar();
        setSwitchDarkTheme();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setSwitchDarkTheme() {
        SwitchMaterial switchDarkTheme = findViewById(R.id.switch_dark_theme);

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                switchDarkTheme.setChecked(false);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                switchDarkTheme.setChecked(true);
                break;
        }

        switchDarkTheme.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            int mode = isChecked ? MODE_NIGHT_YES : MODE_NIGHT_NO;
            AppCompatDelegate.setDefaultNightMode(mode);
        });
    }
}
