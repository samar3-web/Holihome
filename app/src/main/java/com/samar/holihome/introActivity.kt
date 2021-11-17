package com.samar.holihome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class introActivity : AppCompatActivity() {

    private lateinit var startBtn : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        startBtn = findViewById(R.id.startbtn)
        // creation de notre intent
        val monIntent : Intent =  Intent(this,MainActivity::class.java)
        //clic sur le bouton
        startBtn.setOnClickListener {
            startActivity(monIntent)
        }


    }
}