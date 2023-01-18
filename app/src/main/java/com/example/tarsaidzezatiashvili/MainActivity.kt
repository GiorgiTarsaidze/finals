package com.example.tarsaidzezatiashvili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tarsaidzezatiashvili.starter
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val goback1: Button = findViewById(R.id.goback1)

        val Ricxvi1: EditText = findViewById(R.id.Ricxvi1)
        val Ricxvi2: EditText = findViewById(R.id.Ricxvi2)
        val addnum: TextView = findViewById(R.id.addnum)
        val subnum: TextView = findViewById(R.id.subnum)
        val multnum: TextView = findViewById(R.id.multnum)
        val dividenum: TextView = findViewById(R.id.dividenum)
        val result: TextView = findViewById(R.id.Calculator)





        addnum.setOnClickListener {
            val num1 = Ricxvi1.text.toString().toDouble()
            val num2 = Ricxvi2.text.toString().toDouble()

            val result1 = num1 + num2

            result.text = result1.toString()
        }

        subnum.setOnClickListener{
            val num3 = Ricxvi1.text.toString().toDouble()
            val num4 = Ricxvi2.text.toString().toDouble()

            val result2 = num3 - num4

            result.text = result2.toString()
        }

        multnum.setOnClickListener{
            val num5 = Ricxvi1.text.toString().toDouble()
            val num6 = Ricxvi2.text.toString().toDouble()

            val result3 = num5 * num6

            result.text = result3.toString()
        }

        dividenum.setOnClickListener{
            val num7 = Ricxvi1.text.toString().toDouble()
            val num8 = Ricxvi2.text.toString().toDouble()

            val result4 = num7 / num8

            result.text = result4.toString()
        }


        goback1.setOnClickListener{
            val intent1 = Intent(this, starter::class.java)

            startActivity(intent1)
        }



    }



}
