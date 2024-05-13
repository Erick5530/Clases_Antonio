package com.mc.movil.view.activitys

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mc.movil.R

class MainActivity : AppCompatActivity() {

    private lateinit var tvSaludo : TextView
    private lateinit var tvNombre : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initBinding()
        initListeners()
    }

    private fun initBinding(){
        setContentView(R.layout.activity_main)
        tvSaludo = findViewById(R.id.tvSaludo)
        tvNombre = findViewById(R.id.tvNombre)
    }

    private fun initListeners(){
        tvSaludo.setOnClickListener {
            Toast.makeText(this, "Hola ${tvNombre.text}", Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}