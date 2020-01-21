package com.example.rccontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forwardButton: Button = findViewById(R.id.upArrow)
        val backwardButton: Button = findViewById(R.id.downArrow)
        val rightButton: Button = findViewById(R.id.rightArrow)
        val leftButton: Button = findViewById(R.id.leftArrow)
        val startButton: Button = findViewById(R.id.startButton)
        val ipAddress: EditText = findViewById(R.id.ipAddress)
        val url = "http://" + ipAddress.text.toString() + "/"
        val requestQueue = Volley.newRequestQueue(this)

        startButton.setOnClickListener { Toast.makeText(this, "Ready to Control!",Toast.LENGTH_SHORT).show() }

        forwardButton.setOnClickListener {
            val forwardObject = JSONObject()
            forwardObject.put("State", "F")
            sendGetRequest(url, forwardObject, requestQueue)
        }

        backwardButton.setOnClickListener {
            val backwardObject = JSONObject()
            backwardObject.put("State", "B")
            sendGetRequest(url, backwardObject, requestQueue)
        }

        rightButton.setOnClickListener {
            val rightObject = JSONObject()
            rightObject.put("State", "R")
            sendGetRequest(url, rightObject, requestQueue)
        }

        leftButton.setOnClickListener {
            val leftObject = JSONObject()
            leftObject.put("State", "L")
            sendGetRequest(url, leftObject, requestQueue)
        }
    }

    fun sendGetRequest(url: String, requestObject: JSONObject, requestQueue: RequestQueue)
    {
        val request = JsonObjectRequest(Request.Method.GET, url, requestObject,
            Response.Listener { response -> Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()},
            Response.ErrorListener {Toast.makeText(this, "There was an Error!", Toast.LENGTH_SHORT).show()})

        requestQueue.add(request)
    }
}
