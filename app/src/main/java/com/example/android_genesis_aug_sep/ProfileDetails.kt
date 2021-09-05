package com.example.android_genesis_aug_sep

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile_details.*

class ProfileDetails : AppCompatActivity() {
    lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("loginfile", MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)
        var sp1 : SharedPreferences = getSharedPreferences("registrations", MODE_PRIVATE)
        profileUsername.setText(sp1.getString("username",null))
        profileVehicle.setText(sp1.getString("vehicle",null))
        profileCountry.setText(sp1.getString("country",null))
        profileGender.setText(sp1.getString("gender",null))
        buttonHome.setOnClickListener {
            var i = Intent(this, SecondActivity::class.java)
            startActivity(i)

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logout,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if(id==R.id.logout){
            var editor=sp.edit()
            editor.clear()
            editor.commit()
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        return super.onOptionsItemSelected(item)
    }
}