package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var spinNac : Spinner
lateinit var btn1 : Button
lateinit var selectedNac : String


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinNac = findViewById(R.id.spinnerNacionalidad)
        btn1 = findViewById(R.id.Btn1)

        val nacionalidades = listOf("Argentina","EEUU","Brasil")
        val adpNac = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nacionalidades)
        spinNac.adapter = adpNac

        btn1.setOnClickListener {

            selectedNac = spinNac.selectedItem.toString()

            val intent1 = Intent(this, Page2::class.java)
            intent1.putExtra("Nacionalidad", selectedNac)
            startActivity(intent1)
        }
    }
}