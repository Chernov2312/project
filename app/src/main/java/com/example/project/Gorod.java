package com.example.project;

import static com.example.project.MainActivity.setM;
import static com.example.project.MainActivity.setMenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project.databinding.GorodBinding;

public class Gorod extends AppCompatActivity {
    GorodBinding binding;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GorodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setM(5);
        intent = new Intent(Gorod.this, MyService.class);
        startService(intent);
        binding.person.setOnClickListener(v -> {
            setMenu(3);
            Intent i = new Intent(Gorod.this, Character_Settings.class);
            startActivity(i);
        });
        binding.Return.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(Gorod.this, startgame.class);
            startActivity(i);
        });
        binding.magazin.setOnClickListener(v -> {
            Character_Settings.setWater(Character_Settings.getWater() - 2);
            Character_Settings.setFood(Character_Settings.getFood() - 1);
            Intent i = new Intent(Gorod.this, magazin.class);
            startActivity(i);
        });
        binding.gild.setOnClickListener(v -> {
            Intent i = new Intent(Gorod.this, gildia.class);
            startActivity(i);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }
}

