package com.example.calculadora

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.*
import kotlin.math.pow


class MainActivity : AppCompatActivity() {


        var mr = 0.0
        var temp1 = 0.0
        var temp2 = 0.0
        var operacao = 0
        var result = 0.0
        var isResult = false

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

        val display = findViewById<TextView>(R.id.display)

        val buttonMap = mapOf(
            R.id.btnZero to "0",
            R.id.btnUm to "1",
            R.id.btnDois to "2",
            R.id.btnTres to "3",
            R.id.btnQuatro to "4",
            R.id.btnCinco to "5",
            R.id.btnSeis to "6",
            R.id.btnSete to "7",
            R.id.btnOito to "8",
            R.id.btnNove to "9"
        )

            buttonMap.forEach { (id, number) ->
                findViewById<TextView>(id).setOnClickListener {
                    if (isResult || display.text.toString() == "0") {
                        display.text = number
                    } else {
                        display.text = display.text.toString().plus(number)
                    }
                    isResult = false
                }
            }


            findViewById<TextView>(R.id.btnCE).setOnClickListener {
                display.text = "0"
                result = 0.0
                operacao = 0
                temp1 = 0.0
                temp2 = 0.0
                isResult = false
            }

            findViewById<TextView>(R.id.btnVirgula).setOnClickListener {
                if (!display.text.contains(".")) {
                    display.text = display.text.toString().plus(".")
                }
            }

            findViewById<TextView>(R.id.btnMR).setOnClickListener {
                display.text = mr.toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnMmais).setOnClickListener {
                mr += display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = "0"
                isResult = true
            }

            findViewById<TextView>(R.id.btnMmenos).setOnClickListener {
                mr -= display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = "0"
                isResult = true
            }

            //Calculo cientifico

            findViewById<TextView>(R.id.btnSen).setOnClickListener {
                val value = display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = kotlin.math.sin(Math.toRadians(value)).toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnCos).setOnClickListener {
                val value = display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = kotlin.math.cos(Math.toRadians(value)).toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnTan).setOnClickListener {
                val value = display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = kotlin.math.tan(Math.toRadians(value)).toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnSqrt).setOnClickListener {
                val value = display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = sqrt(value).toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnQuadrado).setOnClickListener {
                val value = display.text.toString().toDoubleOrNull() ?: 0.0
                display.text = (value * value).toString()
                isResult = true
            }

            findViewById<TextView>(R.id.btnPotencia).setOnClickListener {
                temp1 = display.text.toString().toDoubleOrNull() ?: 0.0
                operacao = 5 // novo código para xʸ
                display.text = "0"
                isResult = false
            }

            fun setOperacao(op: Int, display: TextView) {
                temp1 = display.text.toString().toDoubleOrNull() ?: 0.0
                operacao = op
                display.text = "0"
                isResult = false
            }


            findViewById<TextView>(R.id.btnMais).setOnClickListener { setOperacao(1, display) }
            findViewById<TextView>(R.id.btnMenos).setOnClickListener { setOperacao(2, display) }
            findViewById<TextView>(R.id.btnVezes).setOnClickListener { setOperacao(3, display) }
            findViewById<TextView>(R.id.btnDividir).setOnClickListener { setOperacao(4, display) }

            findViewById<TextView>(R.id.btnResultado).setOnClickListener {
                temp2 = display.text.toString().toDoubleOrNull() ?: 0.0
                result = when (operacao) {
                    1 -> temp1 + temp2
                    2 -> temp1 - temp2
                    3 -> temp1 * temp2
                    4 -> if (temp2 != 0.0) temp1 / temp2 else Double.NaN
                    5 -> temp1.pow(temp2)
                    else -> 0.0
                }

                display.text = result.toString()
                isResult = true
                temp1 = 0.0
                temp2 = 0.0
                operacao = 0
                result = 0.0
            }


        }
}