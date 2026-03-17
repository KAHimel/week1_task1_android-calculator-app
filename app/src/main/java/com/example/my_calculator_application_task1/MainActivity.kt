package com.example.my_calculator_application_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView

    private var firstNumber = 0.0

    private var operator = ""

    private val engine = CalculatorEngine()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        setupNumbers()

        setupOperators()

        findViewById<Button>(R.id.btnEquals).setOnClickListener {

            calculate()
        }

        findViewById<Button>(R.id.btnAC).setOnClickListener {

            clear()
        }
    }

    private fun setupNumbers() {

        val ids = listOf(

            R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,

            R.id.btn4,R.id.btn5,R.id.btn6,

            R.id.btn7,R.id.btn8,R.id.btn9
        )

        for(id in ids){

            findViewById<Button>(id).setOnClickListener {

                val number = (it as Button).text

                if(display.text == "0")

                    display.text = number

                else

                    display.append(number)
            }
        }
    }

    private fun setupOperators(){

        setOperator(R.id.btnPlus,"+")
        setOperator(R.id.btnMinus,"-")
        setOperator(R.id.btnMultiply,"*")
        setOperator(R.id.btnDivide,"/")
    }

    private fun setOperator(id:Int,op:String){

        findViewById<Button>(id).setOnClickListener{

            firstNumber = display.text.toString().toDouble()

            operator = op

            display.text = "0"
        }
    }

    private fun calculate(){

        try{

            val second = display.text.toString().toDouble()

            val result = engine.calculate(firstNumber,second,operator)

            display.text = result.toString()

        }catch(e:Exception){

            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun clear(){

        display.text="0"

        firstNumber=0.0

        operator=""
    }
}