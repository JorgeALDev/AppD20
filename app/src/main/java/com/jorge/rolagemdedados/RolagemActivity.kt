package com.jorge.rolagemdedados

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RolagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rolagem)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botao_voltar = findViewById<ImageButton>(R.id.voltar)
        val nome_rpg = findViewById<TextView>(R.id.nome_rpg)
        val resultado_dado = findViewById<TextView>(R.id.resultado_dado)
        val girar = findViewById<ImageButton>(R.id.girar)

        val preferences = getSharedPreferences("APP", MODE_PRIVATE)
        val nome = preferences.getString("NOME_RPG", "Sem nome")



        nome_rpg.text = nome

        botao_voltar.setOnClickListener {
            finish()
        }

        girar.setOnClickListener {
            val numero = (1..20).random()
            resultado_dado.text = numero.toString()
        }
    }
}