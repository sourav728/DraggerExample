package com.transvision.draggerexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.transvision.draggerexample.module.SharedPrefModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, number;
    Button save, get;
    private MyComponent myComponent;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edit_name);
        number = findViewById(R.id.edit_number);
        save = findViewById(R.id.btnSave);
        get = findViewById(R.id.btnGet);
        save.setOnClickListener(this);
        get.setOnClickListener(this);
        //binding dagger into Main Activity
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name.getText().toString());
                editor.putString("number", number.getText().toString());
                editor.apply();
                break;
            case R.id.btnGet:
                name.setText(sharedPreferences.getString("name", ""));
                number.setText(sharedPreferences.getString("number", ""));
                break;
        }
    }
}
