package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.calculator.databinding.ActivityMainBinding
import com.ezylang.evalex.Expression

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val numberStringBuilder = StringBuilder()
    private val historyList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: ConstraintLayout = binding.root
        setContentView(view)

        setListeners()
    }

    private fun setListeners() = with(binding) {
        zeroButton.setOnClickListener {
            numberStringBuilder.append(0)
            resultTextView.text = numberStringBuilder
        }

        oneButton.setOnClickListener {
            numberStringBuilder.append(1)
            resultTextView.text = numberStringBuilder
        }

        twoButton.setOnClickListener {
            numberStringBuilder.append(2)
            resultTextView.text = numberStringBuilder
        }

        threeButton.setOnClickListener {
            numberStringBuilder.append(3)
            resultTextView.text = numberStringBuilder
        }

        fourButton.setOnClickListener {
            numberStringBuilder.append(4)
            resultTextView.text = numberStringBuilder
        }

        fiveButton.setOnClickListener {
            numberStringBuilder.append(5)
            resultTextView.text = numberStringBuilder
        }

        sixButton.setOnClickListener {
            numberStringBuilder.append(6)
            resultTextView.text = numberStringBuilder
        }

        sevenButton.setOnClickListener {
            numberStringBuilder.append(7)
            resultTextView.text = numberStringBuilder
        }

        eightButton.setOnClickListener {
            numberStringBuilder.append(8)
            resultTextView.text = numberStringBuilder
        }

        nineButton.setOnClickListener {
            numberStringBuilder.append(9)
            resultTextView.text = numberStringBuilder
        }

        pointButton.setOnClickListener {
            numberStringBuilder.append(".")
            resultTextView.text = numberStringBuilder
        }

        plusButton.setOnClickListener {
            numberStringBuilder.append("+")
            resultTextView.text = numberStringBuilder
        }

        minusButton.setOnClickListener {
            numberStringBuilder.append("-")
            resultTextView.text = numberStringBuilder
        }

        multiplyButton.setOnClickListener {
            numberStringBuilder.append("*")
            resultTextView.text = numberStringBuilder
        }

        divideButton.setOnClickListener {
            numberStringBuilder.append("/")
            resultTextView.text = numberStringBuilder
        }

        clearButton.setOnClickListener {
            numberStringBuilder.clear()
            resultTextView.text = "0"
        }

        resetButton.setOnClickListener {
            numberStringBuilder.deleteCharAt(numberStringBuilder.length - 1)
            resultTextView.text = numberStringBuilder
        }

        historyButton.setOnClickListener {
            TODO()
        }

        equalButton.setOnClickListener {
            saveHistory()
            binding.calculate()
        }
    }

    private fun ActivityMainBinding.calculate() {
        try {
            val stringExpression = numberStringBuilder.toString()
            val expression = Expression(stringExpression)
            val expressionResult = expression.evaluate().numberValue
            resultTextView.text = expressionResult.toString()

            numberStringBuilder.clear()
            numberStringBuilder.append(expressionResult.toString())
        } catch (t: Throwable) {
            Toast.makeText(this@MainActivity, "Exception: $t", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun saveHistory() {
        val stringExpression = numberStringBuilder.toString()
        historyList.add(stringExpression)
    }
}