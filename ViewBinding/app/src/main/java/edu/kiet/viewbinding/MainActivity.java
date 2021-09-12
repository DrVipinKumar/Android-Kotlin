package edu.kiet.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.kiet.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setmsg.setText("Welcome to Android View Binding Example");
        binding.button.setText("Press On Me");
    }
}