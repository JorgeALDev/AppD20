package com.jorge.rolagemdedados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nome_rpg = findViewById<EditText>(R.id.nome_rpg_resposta)
        val botao = findViewById<Button>(R.id.botao_confirmar)


        botao.setOnClickListener {

            val nome = nome_rpg.text.toString()

            val preferences = getSharedPreferences("APP", MODE_PRIVATE)
            val editar = preferences.edit()
            editar.putString("NOME_RPG", nome)
            editar.apply()

            val intent = Intent(this, RolagemActivity::class.java)
            startActivity(intent)
        }
    }
}