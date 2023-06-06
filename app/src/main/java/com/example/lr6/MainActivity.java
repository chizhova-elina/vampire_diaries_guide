package com.example.lr6;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
// Задание:
// работа с фотографиями через int (drawble), вывести недоступно если нет, несколько конструкторов

public class MainActivity extends AppCompatActivity {

    private Button next;
    private User user;
    private EditText name;
    private EditText surname;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);

        addListenerOnButton();
    }
    public void addListenerOnButton(){
        next=findViewById(R.id.next);
        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!name.getText().toString().equals("")) {
                            user = new User(name.getText().toString(), surname.getText().toString(), email.getText().toString());
                            Intent intent = new Intent(MainActivity.this,ListActivity.class);
                            intent.putExtra(User.class.getCanonicalName(), user);
                            startActivity(intent);
                        }
                        else Toast.makeText(MainActivity.this, "введите ваше имя", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}