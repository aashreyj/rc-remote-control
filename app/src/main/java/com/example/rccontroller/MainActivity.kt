package com.example.rccontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val RequestQueue = Volley.newRequestQueue(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forwardButton: Button = findViewById(R.id.upArrow)
        val backwardButton: Button = findViewById(R.id.downArrow)
        val rightButton: Button = findViewById(R.id.rightArrow)
        val leftButton: Button = findViewById(R.id.leftArrow)
    }

    
}
