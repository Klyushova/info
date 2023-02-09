package com.example.info;
import static java.lang.String.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.info.databinding.ActivityMainBinding;
import com.example.info.databinding.MenuBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private MenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.lets.setOnClickListener(view -> startActivity(Rasvilka.newInstance(this)));


    }
}