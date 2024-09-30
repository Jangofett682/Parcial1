package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class Page2 : AppCompatActivity() {

    lateinit var deporList: ListView
    lateinit var txVwDepor: TextView
    lateinit var nacion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        deporList = findViewById(R.id.ListViewNombres)
        txVwDepor = findViewById(R.id.TxVwDeportistas)


        val bundle = Bundle(intent.extras)
        nacion = bundle?.getString("Nacionalidad") ?: ""

        txVwDepor.text = "Deportistas de: $nacion"


        if (nacion == "Argentina") {


            val argentinos = DeporArg()
            val adapterArg = ArrayAdapter(this, android.R.layout.simple_list_item_1  , argentinos)
            deporList.adapter = adapterArg

            deporList.setOnItemClickListener { parent, view, position, id ->

                val selectedDep = argentinos[position]

                val intent2 = Intent(this, Page3::class.java)
                intent2.putExtra("nombre", selectedDep.Nombre)
                intent2.putExtra("deporte", selectedDep.Deporte)
                intent2.putExtra("activo", selectedDep.Activo)
                startActivity(intent2)
            }
        } else if (nacion == "EEUU") {
            val yanques = DeporUSA()
            val adapterUsa = ArrayAdapter(this, android.R.layout.simple_list_item_1, yanques)
            deporList.adapter = adapterUsa

            deporList.setOnItemClickListener { parent, view, position, id ->

                val selectedDep = yanques[position]

                val intent2 = Intent(this, Page3::class.java)
                intent2.putExtra("nombre", selectedDep.Nombre)
                intent2.putExtra("deporte", selectedDep.Deporte)
                intent2.putExtra("activo", selectedDep.Activo)
                startActivity(intent2)
            }

        } else if (nacion == "Brasil") {
            val brasileros = DeporBr()
            val adapterBr = ArrayAdapter(this, android.R.layout.simple_list_item_1, brasileros)
            deporList.adapter = adapterBr

            deporList.setOnItemClickListener { parent, view, position, id ->

                val selectedDep = brasileros[position]

                val intent2 = Intent(this, Page3::class.java)
                intent2.putExtra("nombre", selectedDep.Nombre)
                intent2.putExtra("deporte", selectedDep.Deporte)
                intent2.putExtra("activo", selectedDep.Activo)
                startActivity(intent2)
            }

        }
    }


     fun DeporArg(): MutableList<Deportistas> {
        return mutableListOf<Deportistas>(
            Deportistas(1, "Messi", Deportes.Futbol, true),
            Deportistas(2, "Maradona", Deportes.Futbol, false),
            Deportistas(3, "Riquelme", Deportes.Futbol, false),
            Deportistas(4, "Ginobili", Deportes.Basket, false),
            Deportistas(5, "Colapinto", Deportes.F1, true),
            Deportistas(6, "Del Potro", Deportes.Tenis, false),
            Deportistas(7, "Di Maria", Deportes.Futbol, true),
            Deportistas(8, "Fangio", Deportes.F1, false),
            Deportistas(9, "Nalbandian", Deportes.Tenis, false),
            Deportistas(10, "Batistuta", Deportes.Futbol, false)
        )

    }


    private fun DeporUSA(): MutableList<Deportistas>
    {
        return mutableListOf(
            Deportistas(1, "LeBron", Deportes.Basket, true),
            Deportistas(2, "Kobe", Deportes.Basket, false),
            Deportistas(3, "Pullisic", Deportes.Futbol, true),
            Deportistas(4, "O´Neill", Deportes.Basket, false),
            Deportistas(5, "Sargeant", Deportes.F1, true),
            Deportistas(6, "Dest", Deportes.Futbol, true),
            Deportistas(7, "McKennie", Deportes.Futbol, true),
            Deportistas(8, "Jones", Deportes.MMA, true),
            Deportistas(9, "Covington", Deportes.MMA, true),
            Deportistas(10, "Porier", Deportes.MMA, true)
        )
    }
    private fun DeporBr(): MutableList<Deportistas>
    {
        return mutableListOf(
            Deportistas(1, "Pele", Deportes.Futbol, false),
            Deportistas(2, "Ronaldinho", Deportes.Futbol, false),
            Deportistas(3, "Cafu", Deportes.Futbol, false),
            Deportistas(4, "Silva", Deportes.MMA, false),
            Deportistas(5, "Oliveira", Deportes.MMA, true),
            Deportistas(6, "Zico", Deportes.Futbol, false),
            Deportistas(7, "Neymar", Deportes.Futbol, true),
            Deportistas(8, "Senna", Deportes.F1, false),
            Deportistas(9, "Schmidt", Deportes.Basket, false),
            Deportistas(10, "Barbosa", Deportes.Futbol, true)
        )
    }
}