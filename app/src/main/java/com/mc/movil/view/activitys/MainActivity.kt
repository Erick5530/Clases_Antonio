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
        Toast.makeText(this, "dentro de onCreate", Toast.LENGTH_LONG).show()
        mainViewModel.saludarCada3s()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "dentro de onStart", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "dentro de onPause", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "dentro de onResume", Toast.LENGTH_LONG).show()}

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "dentro de onStop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "dentro de onDestroy", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "dentro de onRestart", Toast.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(this, "dentro de onSaveInstanceState", Toast.LENGTH_LONG).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Toast.makeText(this, "dentro de onRestoreInstanceState", Toast.LENGTH_LONG).show()
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