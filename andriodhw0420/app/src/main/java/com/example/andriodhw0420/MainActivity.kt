package com.example.andriodhw0420

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var user:EditText;
    private lateinit var password:EditText;
    private lateinit var btn_login:Button;

    private  var correct_name = "aaa";
    private  var correct_password = "123";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.editTextTextuser)
        password = findViewById(R.id.editTextTextPassword)
        btn_login = findViewById(R.id.button)

        btn_login.setOnClickListener {
            //檢查輸入
            if(TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(this,"未輸入登入資訊",Toast.LENGTH_LONG).show();
            }else if(user.getText().toString().equals(correct_name)){
                //檢查密碼
                if(password.getText().toString().equals(correct_password)){
                    Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
                    startActivity(Intent(this,MainActivity2::class.java))
                }else{
                    Toast.makeText(this,"帳號/密碼錯誤",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"帳號/密碼錯誤",Toast.LENGTH_LONG).show();
            }

        }
    }
}