package com.perob.languages;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, passwordEditText;
    Button checkButton, changeLanguageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        checkButton = (Button) findViewById(R.id.checkButton);
        changeLanguageButton = (Button) findViewById(R.id.changeLanguageButton);
        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.languages_menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.language_item_english :
                changeLanguage ("en");
                break;
            case R.id.language_item_arabic :
                changeLanguage ("ar");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeLanguage (String language) {
        Locale locale = new Locale(language);
        locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_main);
    }
}
