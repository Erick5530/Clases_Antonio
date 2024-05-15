package com.mc.movil.view.activitys

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mc.movil.R
import com.mc.movil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    private lateinit var tvSaludo : TextView
//    private lateinit var tvNombre :
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initBinding()
        initListeners()
    }

    private fun initBinding() {
//        setContentView(R.layout.activity_main)
//        tvSaludo = findViewById(R.id.tvSaludo)
//        tvNombre = findViewById(R.id.tvNombre)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initListeners() {
        binding.tvSaludo.setOnClickListener {

            Toast.makeText(this, "Hola ${binding.tvNombre.text}", Toast.LENGTH_LONG).show()
        }
//                                               findViewById(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}