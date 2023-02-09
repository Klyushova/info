package com.example.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.info.databinding.ButtonMenuBinding;

public class Rasvilka extends AppCompatActivity {
    private ButtonMenuBinding binding;
    public static Intent newInstance(Context context) {
        return new Intent(context, Rasvilka.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ButtonMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button nexti =(Button)findViewById(R.id.button);
        nexti.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
     binding.clogi.setOnClickListener(view -> {
            startActivity(Clogi.newInstance( this));
        });
        binding.legi.setOnClickListener(view -> {
            startActivity(Legi.newInstance( this));
        });
    }

}
