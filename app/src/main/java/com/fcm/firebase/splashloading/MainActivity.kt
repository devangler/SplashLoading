package com.fcm.firebase.splashloading

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val width: Int = resources.displayMetrics.widthPixels
        val setNum: TextView = findViewById(R.id.num)
        val layout: LinearLayout = findViewById(R.id.foreground)
        val layout2: LinearLayout = findViewById(R.id.foreground2)
        layout2.visibility = View.GONE
        var value = 0
        object : CountDownTimer(60000, 70) {
            override fun onTick(millisUntilFinished: Long) {
                value += 1
                if (value > 100) {
                    Handler().postDelayed({
                        setNum.text = "$value/%"
                        setNum.text = getString(R.string.start)

                    }, 200)

                } else {

                    if (value == 100) {
                        Handler().postDelayed({
                            setNum.text = "$value/%"

                        }, 200)
                    } else {
                        setNum.text = "$value/%"
                    }
                }

                val params: ViewGroup.LayoutParams = layout.layoutParams
                when (width) {
                    1080 -> {
                        params.width = value * 10
                    }
                    720 -> {
                        params.width = value * 6
                    }
                    else -> {
                        params.width = value * 9
                    }
                }
                layout.layoutParams = params
            }

            override fun onFinish() {
            }
        }.start()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}