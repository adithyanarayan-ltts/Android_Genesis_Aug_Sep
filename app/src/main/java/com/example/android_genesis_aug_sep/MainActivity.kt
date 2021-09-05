package com.example.android_genesis_aug_sep

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sp : SharedPreferences
    lateinit var sp1 : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp1 = getSharedPreferences("registrations", MODE_PRIVATE)
        sp = getSharedPreferences("loginfile", MODE_PRIVATE)
        if (sp.getBoolean("status",false)) {
            editTextUsername.setText(sp.getString("username",""))
            editTextPassword.setText(sp.getString("password",""))
            startActivity(Intent(this, SecondActivity::class.java))
            finish() //finish current activity
        }
        buttonRegister.setOnClickListener {
            var i = Intent(this, RegistrationActivity::class.java)
            startActivity(i)
        }
        buttonLogin.setOnClickListener{
            var username = editTextUsername.text.toString()
            var password = editTextPassword.text.toString()
            if(sp1.getString("username","")==username && sp1.getString("password","")==password){
                if(checkBox.isChecked()){
                    var editor = sp.edit()
                    editor.putString("username",username)
                    editor.putString("password",password)
                    editor.putBoolean("status",true)
                    editor.commit()
                }
                else{
                    var editor = sp.edit()
                    editor.putString("username",username)
                    editor.putString("password",password)
                    editor.putBoolean("status",false)
                    editor.commit()
                }
                var i = Intent(this, SecondActivity::class.java)
                startActivity(i)
            }
            else
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show()
        }

    }
}