package com.mc.movil.view.activitys

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mc.movil.databinding.ActivityMainBinding
import com.mc.movil.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initBinding()
        initListeners()
        initObservers()
        mainViewModel.saludarCada3s()
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initListeners() {
        binding.tvSaludo.setOnClickListener {
            Toast.makeText(this, "Hola ${binding.tvNombre.text}", Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initObservers() {
        mainViewModel.textoSaludo.observe(this, ::processTextoSaludo)
    }


    /**
     * Funciones que invocaran los observers al configurar el event observe de los LiveData
     * */

    private fun processTextoSaludo(newSaludo: String) {
        binding.tvSaludo.text = newSaludo
    }

}