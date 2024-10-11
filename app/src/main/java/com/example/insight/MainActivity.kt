package com.example.insight

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstname = findViewById<EditText>(R.id.firstname)
        val lastname = findViewById<EditText>(R.id.lastname)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)

//        //        Ip address handling
//        val block1 = findViewById<EditText>(R.id.block1)
//        val block2 = findViewById<EditText>(R.id.block2)
//        val block3 = findViewById<EditText>(R.id.block3)
//        val block4 = findViewById<EditText>(R.id.block4)
//
//        // Get the text from each EditText and convert it to a string
//        val block1Text = block1.text.toString()
//        val block2Text = block2.text.toString()
//        val block3Text = block3.text.toString()
//        val block4Text = block4.text.toString()
//
//        // Concatenate the text to form the address
//        val address = "$block1Text.$block2Text.$block3Text.$block4Text"
//
//        // Construct the API URL based on whether the address is empty or not
//        val api = if (address.isNotBlank()) "http://$address:8000/apis/add-some" else "http://172.16.109.41:8000/apis/add-some"

        val submitbtn = findViewById<Button>(R.id.submit)

        submitbtn.setOnClickListener {
            val body = JSONObject()
            body.put("firstname", firstname.text.toString())
            body.put("lastname", lastname.text.toString())
            body.put("email", email.text.toString())
            body.put("phone", phone.text.toString())

            val api = "http://172.16.119.29:8000/apis/add-some"

            val helper = ApiHelper(applicationContext)

            helper.post(api, body)
        }
    }
}