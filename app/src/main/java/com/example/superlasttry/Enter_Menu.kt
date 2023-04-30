package com.example.superlasttry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Enter_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_menu)
        val button1 = findViewById<Button>(R.id.student_button)
        val button2 = findViewById<Button>(R.id.guess_button)
        button2.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        button1.setOnClickListener{
            showRegistration()
        }
    }

    private fun showRegistration(){
        val registrationBlank = findViewById<View>(R.id.registrationBlank)
        val registrMenu = findViewById<View>(R.id.registrMenu)
        registrationBlank.visibility=View.VISIBLE
        registrMenu.visibility=View.GONE
    }
}