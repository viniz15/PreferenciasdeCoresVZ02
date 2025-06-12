package com.example.preferenciasdecoresvz02

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preferenciasdecoresvz02.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object{
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    private var cor = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.statusBarColor = Color.WHITE

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCor1.setOnClickListener {
            cor = "#F02F24"
            salvarCor(cor)
        }

        binding.btnCor2.setOnClickListener {
            cor = "#2196F3"
            salvarCor(cor)
        }

        binding.btnCor3.setOnClickListener {
            cor = "#4CAF50"
            salvarCor(cor)
        }

        binding.btnCor4.setOnClickListener {
            cor = "#FD6A3A"
            salvarCor(cor)
        }

        binding.btnCor5.setOnClickListener {
            cor = "#8A4CF6"
            salvarCor(cor)
        }
        binding.trocar.setOnClickListener {

        }

    }

    override fun onResume() {
        super.onResume()

        val preferecias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferecias.getString("cor", "")

        if (cor!!.isNotEmpty()){
            binding.main.setBackgroundColor(Color.parseColor(cor))
        }
    }

    private fun salvarCor(cor: String){
            binding.main.setBackgroundColor(Color.parseColor(cor))

        binding.trocar.setOnClickListener {view ->

            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor",cor)
            editor.apply()

            snackBar(view)
        }


    }

    private fun snackBar(view: View){
        val snackbar = Snackbar.make(view, "Cor de Fundo Alterada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
    }
}