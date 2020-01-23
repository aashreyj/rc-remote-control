package com.example.rccontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
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
        val stopButton: Button = findViewById(R.id.stopButton)
        val ipAddress: EditText = findViewById(R.id.ipAddress)
        val urlConnect = "http://192.168.4.1:8000/"
        val urlControl = "http://192.168.4.1:8000/control"
        val requestQueue = Volley.newRequestQueue(this)

        startButton.setOnClickListener {
            sendGetRequest(urlConnect, requestQueue)
        }

        forwardButton.setOnClickListener {
            val forwardObject = JSONObject()
            forwardObject.put("State", "F")
            sendPostRequest(urlControl, forwardObject, requestQueue)
        }

        backwardButton.setOnClickListener {
            val backwardObject = JSONObject()
            backwardObject.put("State", "B")
            sendPostRequest(urlControl, backwardObject, requestQueue)
        }

        rightButton.setOnClickListener {
            val rightObject = JSONObject()
            rightObject.put("State", "R")
            sendPostRequest(urlControl, rightObject, requestQueue)
        }

        leftButton.setOnClickListener {
            val leftObject = JSONObject()
            leftObject.put("State", "L")
            sendPostRequest(urlControl, leftObject, requestQueue)
        }

        stopButton.setOnClickListener {
            val stopObject = JSONObject()
            stopObject.put("State", "S")
            sendPostRequest(urlControl, stopObject, requestQueue)
        }
    }

    fun sendGetRequest(url: String, requestQueue: RequestQueue)
    {
        val request = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->  },
            Response.ErrorListener {
                Toast.makeText(this, "There was an Error!", Toast.LENGTH_SHORT).show()
                Log.e("VOLLEY", it.message)
            })

        requestQueue.add(request)
        Toast.makeText(this, "Connected!", Toast.LENGTH_SHORT).show()
    }

    fun sendPostRequest(url: String, requestObject: JSONObject, requestQueue: RequestQueue)
    {
        val request = JsonObjectRequest(Request.Method.POST, url, requestObject,
            Response.Listener { response ->  },
            Response.ErrorListener {
                Log.e("VOLLEY", it.message)
            })

        requestQueue.add(request)

        Toast.makeText(this, "Command Sent!", Toast.LENGTH_SHORT).show()
    }
}
