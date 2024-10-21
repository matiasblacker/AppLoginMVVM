package com.example.eje14_login.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eje14_login.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra("EMAIL") ?: "No email provided"

        findViewById<TextView>(R.id.emailTextView).text = email

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            finishAffinity() // Cierra todas las actividades y sale de la app
        }
    }
}