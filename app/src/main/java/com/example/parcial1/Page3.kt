package com.example.parcial1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page3 : AppCompatActivity() {

    lateinit var fin : TextView
    lateinit var act : String
    lateinit var dep : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        fin = findViewById(R.id.fin)

        val bundle = Bundle(intent.extras)

        val name = bundle?.getString("nombre") ?: ""
        val deporte = bundle?.getString("deporte") ?: ""
        val actividad = bundle?.getBoolean("activo") ?: ""


        if(actividad == true)
        {
            act = "En actividad"
        } else {
            act = "Inactivo"
        }
        fin.text = "Deportista: $name\nDeporte: $dep\nActividad: $act"
    }


}