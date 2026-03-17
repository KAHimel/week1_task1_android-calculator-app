package com.example.my_calculator_application_task1

class CalculatorEngine {

    fun calculate(a: Double, b: Double, op: String): Double {

        return when(op) {

            "+" -> a + b

            "-" -> a - b

            "*" -> a * b

            "/" -> {

                if(b == 0.0)
                    throw ArithmeticException("Cannot divide by zero")

                a / b
            }

            else -> 0.0
        }
    }
}