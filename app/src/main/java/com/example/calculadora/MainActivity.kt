package com.example.calculadora

import android.os.Bundle
import android.widget.TextView
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

        var mr = 0.0
        var temp1 = 0.0
        var temp2 = 0.0
        var operacao = 0
        var result = 0.0
        var isResult = false

        val display = findViewById<TextView>(R.id.display)
        val btn0 = findViewById<TextView>(R.id.btnZero)
        val btn1 = findViewById<TextView>(R.id.btnUm)
        val btn2 = findViewById<TextView>(R.id.btnDois)
        val btn3 = findViewById<TextView>(R.id.btnTres)
        val btn4 = findViewById<TextView>(R.id.btnQuatro)
        val btn5 = findViewById<TextView>(R.id.btnCinco)
        val btn6 = findViewById<TextView>(R.id.btnSeis)
        val btn7 = findViewById<TextView>(R.id.btnSete)
        val btn8 = findViewById<TextView>(R.id.btnOito)
        val btn9 = findViewById<TextView>(R.id.btnNove)
        val btnCE = findViewById<TextView>(R.id.btnCE)
        val btnMR = findViewById<TextView>(R.id.btnMR)
        val btnMmais = findViewById<TextView>(R.id.btnMmais)
        val btnMmenos = findViewById<TextView>(R.id.btnMmenos)
        val btnDividir = findViewById<TextView>(R.id.btnDividir)
        val btnVezes = findViewById<TextView>(R.id.btnVezes)
        val btnMenos = findViewById<TextView>(R.id.btnMenos)
        val btnMais = findViewById<TextView>(R.id.btnMais)
        val btnResultado = findViewById<TextView>(R.id.btnResultado)
        val btnVirgula = findViewById<TextView>(R.id.btnVirgula)

        btn0.setOnClickListener{
            if (isResult)
                display.setText("0")
            if (!display.text.toString().equals("0"))
                display.setText(display.text.toString().plus("0"))
        }

        btn1.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("1")
            else
                display.setText(display.text.toString().plus("1"))
        }

        btn2.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("2")
            else
                display.setText(display.text.toString().plus("2"))
        }

        btn3.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("3")
            else
                display.setText(display.text.toString().plus("3"))
        }

        btn4.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("4")
            else
                display.setText(display.text.toString().plus("4"))
        }

        btn5.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("5")
            else
                display.setText(display.text.toString().plus("5"))
        }

        btn6.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("6")
            else
                display.setText(display.text.toString().plus("6"))
        }

        btn7.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("7")
            else
                display.setText(display.text.toString().plus("7"))
        }

        btn8.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("8")
            else
                display.setText(display.text.toString().plus("8"))
        }

        btn9.setOnClickListener{
            if (display.text.toString().equals("0") || isResult)
                display.setText("9")
            else
                display.setText(display.text.toString().plus("9"))
        }

        btnCE.setOnClickListener{
            display.setText("0")
            result = 0.0
            operacao = 0
            temp1 = 0.0
            temp2 = 0.0
            isResult = false
        }

        btnVirgula.setOnClickListener {
            if (!display.text.contains(","))
                display.setText(display.text.toString().plus(","))
        }

        btnMR.setOnClickListener{
            display.setText(mr.toString())
        }

        btnMmais.setOnClickListener {
            mr += display.text.toString().toDouble()
            display.setText("0")
            isResult=true
        }

        btnMmenos.setOnClickListener {
            mr -= display.text.toString().toDouble()
            display.setText("0")
            isResult=true
        }

        btnMais.setOnClickListener {
            temp1 += display.text.toString().toDouble()
            operacao = 1
            display.setText("0")
        }

        btnMenos.setOnClickListener {
            temp1 += display.text.toString().toDouble()
            operacao = 2
            display.setText("0")
        }

        btnVezes.setOnClickListener {
            temp1 += display.text.toString().toDouble()
            operacao = 3
            display.setText("0")
        }

        btnDividir.setOnClickListener {
            temp1 += display.text.toString().toDouble()
            operacao = 4
            display.setText("0")
        }

        btnResultado.setOnClickListener {
            temp2 = display.text.toString().toDouble()

            when(operacao){

                1 -> result = temp1 + temp2
                2 -> result = temp1 - temp2
                3 -> result = temp1 * temp2
                4 -> result = temp1 / temp2

            }
            temp1 = 0.0
            temp2 = 0.0
            operacao = 0
            display.setText(result.toString())
            isResult = true
            result = 0.0
        }
    }
}