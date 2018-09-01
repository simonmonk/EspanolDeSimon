package org.simonmonk.eds

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import java.util.Random

class NumberTester : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun generateRandomNumber(view: View) {

        val numberView = findViewById(R.id.randomNumberView) as TextView
        val spanishView = findViewById(R.id.spanishView) as TextView
        val rangeGroup = findViewById(R.id.range_group) as RadioGroup
        val selectedID = rangeGroup.getCheckedRadioButtonId();
        var minValue = 0
        var maxValue = 1000

        when (selectedID) {
            R.id.radioButton20 -> maxValue = 20
            R.id.radioButton100 -> maxValue = 100
            R.id.radioButton1000 -> maxValue = 1000
            else -> {
                minValue = 1900
                maxValue = 2050
            }
        }
        val random = Random()
        var randomInt = minValue + random.nextInt(maxValue - minValue)
        numberView.text = Integer.toString(randomInt)
        spanishView.text = ""
    }

    fun showSpanish(view: View) {
        val spanishView = findViewById(R.id.spanishView) as TextView
        val numberView = findViewById(R.id.randomNumberView) as TextView
        val n = Integer.parseInt(numberView.text.toString())
        spanishView.text = numeroAtexto(n)
    }
}
