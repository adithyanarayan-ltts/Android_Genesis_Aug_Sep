package com.example.android_genesis_aug_sep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*
import android.content.SharedPreferences
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_registration.view.*


class RegistrationActivity : AppCompatActivity() {
    lateinit var sp: SharedPreferences
    var radioGroup: RadioGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        sp = getSharedPreferences("registrations", MODE_PRIVATE)
        val spinner = findViewById<Spinner>(R.id.spinner_countries) as Spinner
        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries, android.R.layout.simple_spinner_item
        )
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter
        radioGroup = findViewById(R.id.gender)


        buttonSignIn.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i);
        }
        buttonReg.setOnClickListener {
            var username = editTextUsernameReg.text.toString()
            var password = editTextPasswordReg.text.toString()
            var gender: String? = ""
            var vehicle : String? = ""
            var country = spinner.selectedItem.toString()
            if(checkBoxBike.isChecked){
                vehicle += "Bike"
                if(checkBoxCar.isChecked){
                    vehicle +=" & Car"
                }
            }
            else if(checkBoxCar.isChecked) {
                vehicle += "Car"
            }
            if(radioGroup!!.maleButton.isChecked) {
                gender="Male"

            }
            else if(radioGroup!!.femaleButton.isChecked){
                gender="Female"
            }
            else
                gender=""

            if (username.length <= 0) {
                Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            } else if (password.length <= 0) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            } else if (gender.length <= 0) {
                Toast.makeText(this, "Pick Gender", Toast.LENGTH_SHORT).show();
            }
            else if (vehicle!!.length <= 0) {
                Toast.makeText(this, "Pick Vehicle", Toast.LENGTH_SHORT).show();
            }
            else if (country!!.length <= 0) {
                Toast.makeText(this, "Pick Country", Toast.LENGTH_SHORT).show();
            } else {
                var editor = sp.edit()

                // as now we have information in string. Lets stored them with the help of editor
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putString("gender", gender);
                editor.putString("vehicle",vehicle)
                editor.putString("country",country)
                editor.commit();
                var i = Intent(this, MainActivity::class.java)
                startActivity(i);
            }   // commit the values

            // after saving the value open next activity


        }
    }

}