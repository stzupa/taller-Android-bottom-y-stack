package com.example.ejerciciotaller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_acitivity)

        val botonAbrir = findViewById<Button>(R.id.btnAbrir)
        val usuarioCorrecto = "admin"
        val passCorrecta = "1234"
        var usuarioIngresado = findViewById<EditText>(R.id.editTextUsuario)
        var passIngresada = findViewById<EditText>(R.id.editTextPassword)

        botonAbrir.setOnClickListener {

            val usuario = usuarioIngresado.text.toString()
            val pass = passIngresada.text.toString()

            try {
                if (usuario.isBlank() || pass.isBlank()){
                    throw IllegalArgumentException("Debes llenar todos los campos")
                }
                if (usuario != usuarioCorrecto || pass != passCorrecta) {
                    throw IllegalArgumentException("Credenciales no válidas")
                }
                AlertDialog.Builder(this)
                    .setTitle("Confirmación")
                    .setMessage("Para Ingresar Presiona SI")
                    .setPositiveButton("Sí"){dialog, _ ->
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss()
                }.show()

            }catch (e: Exception) {
                // Si ocurre un error en las validaciones o en el proceso
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(e.message) // Muestra el mensaje del error
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()

                Log.e("LOG_Click", "Error en login: ${e.message}")
            }

        }
    }
}