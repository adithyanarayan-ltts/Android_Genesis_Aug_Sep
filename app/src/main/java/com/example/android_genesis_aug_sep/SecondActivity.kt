package com.example.android_genesis_aug_sep

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile_details.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        sp = getSharedPreferences("loginfile", MODE_PRIVATE)
        textView.append(" "+sp.getString("username",""))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
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
        else if(id==R.id.profile){
            var i = Intent(this, ProfileDetails::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}