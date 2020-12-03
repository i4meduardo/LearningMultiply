package com.example.learningtomultiply

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_estudia.*

class EstudiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudia)

        var listaElementos = mutableListOf<String>() //Este es el tipo de datos correcto

        btninicio.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                listaElementos.clear()//aquí limpio la lista
                for(i in 0..10){
                    val texto = "$p1 x $i = ${p1*i}"
                    listaElementos.add(texto)//aquí añado el nuevo elemento
                }
                val adaptador = ArrayAdapter(application,android.R.layout.simple_list_item_1,listaElementos)
                listaTablets.adapter = adaptador
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
}