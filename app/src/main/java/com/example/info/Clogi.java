package com.example.info;

import static java.lang.String.valueOf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.info.databinding.ActivityMainBinding;
import java.util.Random;

public class Clogi extends AppCompatActivity {
    private ActivityMainBinding binding;
    public int randomNumber1;
    public int randomNumber2;
    public int randomX;
    private int answerTr;
    public int TrueX;
    private String Xstr;
    EditText edittext;
    private ImageView imageview;


    public static Intent newInstance(Context context) {
        return new Intent(context, Clogi.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imageview = (ImageView) findViewById(R.id.photo);
        onDiplus();
        binding.diplus.setOnClickListener(view -> onTiDiplus());
        Button nexti =(Button)findViewById(R.id.button);
        nexti.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Rasvilka.class);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void  onTiDiplus() {
        edittext = (EditText) findViewById(R.id.answer);
        try {
            int answerPers = Integer.parseInt(edittext.getText().toString());
            if (answerPers == TrueX){
                binding.piv.setText("Молодец");
                imageview.setImageResource(R.drawable.img_1);
            }
            else{
                binding.piv.setText("Будь внимательней, правильный ответ:" + Xstr);
                imageview.setImageResource(R.drawable.img);
            }
            onDiplus();
        } catch (Exception e) {
            binding.piv.setText("Введите ответ числом");
        }
        edittext.getText().clear();
    }
    protected void onDiplus(){
        Random random = new Random();
        randomNumber1 = random.nextInt(10-1) + 1;
        randomNumber2 = random.nextInt(10-1) + 1;
        answerTr = randomNumber1 * randomNumber2;
        randomX = random.nextInt(2 - 1) + 1;
        switch (randomX){
            case 1:
                TrueX = randomNumber1;
                Xstr = valueOf(randomNumber1) + " = " + valueOf(answerTr)+ " / " + valueOf(randomNumber2);
                binding.priv.setText(" X * "+ valueOf(randomNumber2)+ " = " + valueOf(answerTr));
                break;
            case 2:
                TrueX = randomNumber2;
                Xstr = valueOf(randomNumber2) + " = " + valueOf(answerTr)+ " / " + valueOf(randomNumber1);
                binding.priv.setText(valueOf(randomNumber1) + " * X "+ " = " + valueOf(answerTr));
                break;}
    }
}
