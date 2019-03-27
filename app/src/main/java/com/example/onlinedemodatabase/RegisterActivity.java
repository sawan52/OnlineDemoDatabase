package com.example.onlinedemodatabase;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText editText_name, editText_password, editText_contact, editText_country;
    Button button_insert;
    String name, password, contact, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // change Action bar title, if you don't change it according to your systems default language
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.register_activity));

        editText_name = findViewById(R.id.name_edit_text);
        editText_password = findViewById(R.id.password_edit_text);
        editText_contact = findViewById(R.id.contact_edit_text);
        editText_country = findViewById(R.id.country_edit_text);
        button_insert = findViewById(R.id.insert_button);

        editText_name.requestFocus();

        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                extractDataFromFields();

            }
        });

    }

    private void extractDataFromFields() {

        name = editText_name.getText().toString();
        password = editText_password.getText().toString();
        contact = editText_contact.getText().toString();
        country = editText_country.getText().toString();

        if (TextUtils.isEmpty(name)){
            editText_name.setError("Enter name first");
            editText_name.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)){
            editText_password.setError("Enter password");
            editText_password.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(contact)){
            editText_contact.setError("Enter contact number");
            editText_contact.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(country)){
            editText_country.setError("Enter country name");
            editText_country.requestFocus();
            return;
        }

        String method = "register";
        // create Background Task object and run the execute method on Background Task object...
        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method, name, password, contact, country);
        finish();

    }
}
