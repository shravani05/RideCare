package com.example.shravani.ridecare

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var title : TextView? = null
    var proceed : Button? = null
    var ride : EditText? = null
    var rideName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ride = findViewById(R.id.ride)
        proceed = findViewById(R.id.proceed)
        title = findViewById(R.id.title)

        proceed?.setOnClickListener({

            var intent = Intent(this@MainActivity, Dates::class.java)
            rideName = ride?.getText().toString()
            intent.putExtra("ride",rideName)
            startActivity(intent)
            finish()
        })
    }
}
