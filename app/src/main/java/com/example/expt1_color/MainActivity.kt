package com.example.expt1_color

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private var currentColorIndex = 0
    private val colors = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA)

    private var currentSize = 20f // starting size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
    }

    fun changeColor(view: View) {
        // Change color from the array
        textView.setTextColor(colors[currentColorIndex])
        currentColorIndex = (currentColorIndex + 1) % colors.size
    }

    fun changeSize(view: View) {
        // Increase size by 5 each click, reset if too big
        textView.textSize = currentSize
        currentSize += 5f
        if (currentSize > 40f) { // After 40sp, reset to 20sp
            currentSize = 20f
        }
    }

    fun changeFont(view: View) {
        // Toggle between normal and bold italic
        if (textView.typeface?.style == Typeface.ITALIC) {
            textView.setTypeface(null, Typeface.BOLD)
        } else {
            textView.setTypeface(null, Typeface.ITALIC)
        }
    }
}
