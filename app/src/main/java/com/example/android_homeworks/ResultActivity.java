package com.example.android_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_homeworks.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityResultBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.photoButton.setOnClickListener(this);
        Intent intent = getIntent();
        String mail = intent.getStringExtra("mail");
        binding.helloText.setText("Привет, " + mail + ")");


    }
    @Override
    public void onClick(View view){
        // Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
       // intent.setType("png");
       /// startActivity(intent);
        Toast.makeText(this, "Упс, функция в разработке", Toast.LENGTH_SHORT).show();
        Log.d("PHOTO", "Photo is ready");
    }
}

