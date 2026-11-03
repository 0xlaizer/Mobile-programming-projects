package com.example.promotionalapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMain = findViewById<Button>(R.id.btnMain)
        val touchPanel = findViewById<android.view.View>(R.id.touchPanel)

        // 1. Click
        btnMain.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_click), Toast.LENGTH_SHORT).show()
        }

        // 2. Long click
        btnMain.setOnLongClickListener {
            Toast.makeText(this, getString(R.string.toast_long_click), Toast.LENGTH_SHORT).show()
            true
        }

        // 3. Touch
        touchPanel.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.setBackgroundColor(ContextCompat.getColor(this, R.color.colorTouchPressed))
                    v.scaleX = 0.95f
                    v.scaleY = 0.95f
                    Toast.makeText(this, getString(R.string.toast_touch_down), Toast.LENGTH_SHORT).show()
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.setBackgroundColor(ContextCompat.getColor(this, R.color.colorTouchIdle))
                    v.scaleX = 1f
                    v.scaleY = 1f
                    Toast.makeText(this, getString(R.string.toast_touch_up), Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}