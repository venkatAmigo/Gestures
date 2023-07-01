package com.example.gestures

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.OnDoubleTapListener
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    private val DEBUG_TAG: String? = "TAG"
    lateinit var textView: TextView

    lateinit var gestureDetector: GestureDetectorCompat
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)


        textView.setOnTouchListener(object:MyGestureHandler(this){
            override fun onLongClick() {
                super.onLongClick()
                Toast.makeText(this@MainActivity, "Long Clicked me", Toast.LENGTH_SHORT).show()
            }

            override fun onClick() {
                super.onClick()
                Toast.makeText(this@MainActivity, "Clicked me", Toast.LENGTH_SHORT).show()
            }

            override fun onDoubleClick() {
                super.onDoubleClick()
                Toast.makeText(this@MainActivity, "Double Clicked me", Toast.LENGTH_SHORT).show()
            }
        })


    }

}