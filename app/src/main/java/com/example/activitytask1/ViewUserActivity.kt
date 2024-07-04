package com.example.activitytask1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class ViewUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_user)
        val userIdTextView : TextView = findViewById(R.id.TextViewUserId)
        val userNameTextView : TextView = findViewById(R.id.TextViewUserName)
        val userPhoneTextView : TextView = findViewById(R.id.TextViewUserPhone)
        var userId = intent.getStringExtra("USERID")
        var userName = intent.getStringExtra("USERNAME")
        var userPhone = intent.getStringExtra("USERPHONE")
        userIdTextView.text = "User Id : $userId"
        userNameTextView.text = "User Name : $userName"
        userPhoneTextView.text = "User Phone: $userPhone"
    }
}