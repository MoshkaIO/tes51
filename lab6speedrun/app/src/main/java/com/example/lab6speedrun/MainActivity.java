package com.example.lab6speedrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yandex.mapkit.MapKitFactory;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("abfcc1e5-4686-432a-9097-1066126621d9");
        setContentView(R.layout.activity_main);
    }
    public void onNextButtonClick(View view){
        Log.d("ON_CLICK", "________________ НАЖАТИЕ! первый экран");
        User Guest;
        EditText Name = findViewById(R.id.editTextName);
        EditText Fam = findViewById(R.id.editTextFam);
        EditText Email = findViewById(R.id.editTextEmail);
        TextView Error = findViewById(R.id.ErrorText);

        if (Name.getText().toString().equals("")){
            Error.setText("Поле \"имя\" обязательно к заполнению!");
        }
        else {
            Log.d("ON_CLICK", "________________ ПЕРЕХОД! на второй экран");
            Guest = new User (Name.getText().toString(),Fam.getText().toString(),Email.getText().toString());
            ////////////
            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            intent.putExtra(User.class.getSimpleName(),  Guest);
            startActivity(intent);
        }
    }
//программа посвящена различным вокзалам
    //вокзалы Москвы и Питера
    //у вокзалов есть параметры: архитектор, год постройки, вместимость  и т.п.
    //кнопка "выбери свой идеальный вокзал"
    //отдельная активити, где пользователь задаёт нужные ему параметры
    //ему выводится его любимый вокзал
}