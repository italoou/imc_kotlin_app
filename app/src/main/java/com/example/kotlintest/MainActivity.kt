package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPeso = findViewById(R.id.edit_text_peso)
        editTextAltura = findViewById(R.id.edit_text_altura)
        buttonCalcular = findViewById(R.id.button_calcular)
        textViewResult = findViewById(R.id.textViewResult)

        //validar

        buttonCalcular.setOnClickListener{
            if(!validar()){
                calcular()
            }
        }

    }

    private fun validar() : Boolean {
        var error = false

        if(editTextPeso.text.isEmpty()){
            editTextPeso.error = "Digite seu peso!"
            error = true
        }

        if(editTextAltura.text.isEmpty()){
            editTextAltura.error = "Digite sua altura!"
            error = true
        }

        return error
    }

    private fun calcular() {

        val peso = editTextPeso.text.toString().toDouble()
        val altura = editTextAltura.text.toString().toDouble()

        var imc = peso/(altura*altura)

        var mensagem = ""

        if(imc < 18.5){
            mensagem = "Abaixo do peso normal"
        }else if(18.5 <= imc && imc <= 24.9){
            mensagem = "Peso normal"
        }else if(24.9 < imc && imc <= 29.9){
            mensagem = "Excesso de peso"
        }else if(29.9 < imc && imc <= 34.5){
            mensagem = "Obesidade classe I"
        }else if(34.5 < imc && imc <= 39.9){
            mensagem = "Obesidade classe II"
        }else if(39.9 < imc ){
            mensagem = "Obesidade classe III"
        }

        textViewResult.text = "" + String.format("%.1f", imc).toDouble() + ": " + mensagem
    }
}