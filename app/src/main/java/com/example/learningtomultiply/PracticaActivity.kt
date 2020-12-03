package com.example.learningtomultiply

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_estudia.*
import kotlinx.android.synthetic.main.activity_practica.*
import java.util.*
import kotlin.random.Random

class PracticaActivity : AppCompatActivity() {
    var resultado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        btnVolver.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        generaOperacion()

        btnVerifica.setOnClickListener {
            val resText = etRespuesta.text.toString()
            if (!resText.equals("")){
                val respuesta = resText.toInt()
                if (respuesta==resultado){
                    Log.d("Resultado","Acertaste")
                    crearDialogoOk()
1818                }else{
                    Log.d("Resultado","No Acertaste")
                    crearDialogoFallo()
                }
            }


            generaOperacion()
        }

    }
    fun crearDialogoOk(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.liagolo_ok,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Acertaste!!")
        val miDialogoOk = mBuilder.create()
        miDialogoOk.show()
        val miPlayer:MediaPlayer? = MediaPlayer.create(this,R.raw.acertast)
        miPlayer?.start()


    }
    fun crearDialogoFallo(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_error,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Fallaste!!")
        val miDialogoError = mBuilder.create()
        miDialogoError.show()
        val miPlayer:MediaPlayer? = MediaPlayer.create(this,R.raw.blonderedhead)
        miPlayer?.start()
    }

    fun generaOperacion(){
        val operando1 = Random.nextInt(1,10)
        val operando2 = Random.nextInt(1,10)

        resultado = operando1*operando2
        tvPregunta.text = "$operando1 x $operando2 = ?"
        etRespuesta.text.clear()
    }
}