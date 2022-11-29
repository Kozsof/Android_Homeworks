package com.example.android_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_homeworks.databinding.ActivityFormBinding;

public class FormActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityFormBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ok.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        Intent intent = new Intent(FormActivity.this, ResultActivity.class);
        String mail = binding.mail.getText().toString();
        String pass = binding.pass.getText().toString();
        if (!checkMail(mail)){
            Toast.makeText(this, "Почта должна содержать символ @", Toast.LENGTH_SHORT).show();
            mail = binding.mail.getText().toString();
        }
        if(!checkPass(pass)){
            Toast.makeText(this, "Пароль должен быть больше 8 символов", Toast.LENGTH_SHORT).show();
            pass = binding.pass.getText().toString();
        }
        if(checkPass(pass) && checkMail(mail)) {
        intent.putExtra("mail", mail);
        intent.putExtra("password", pass);
        startActivity(intent);
        Log.d("MAIL AND PASS", mail + " " + pass);
        finish();}
    }
    public Boolean checkPass(String pass){
        if (pass.length() < 8){
            return false;
        }
        return true;
    }
    public Boolean checkMail(String mail){
        if (mail.contains("@")){
            return true;
        }
        return false;
    }
}
