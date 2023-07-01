package com.example.gestures

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

internal  open class MyGestureHandler(context: Context): OnTouchListener {
    private val gestureDetector : GestureDetector

    init {
        gestureDetector = GestureDetector(context,GestureListener())
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        p0?.performClick()
        if (p1 != null) {
            return gestureDetector.onTouchEvent(p1)
        }
        return true
    }

    inner class GestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTap(e: MotionEvent): Boolean {
            onDoubleClick()
            return super.onDoubleTap(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            onClick()
            return super.onSingleTapConfirmed(e)
        }

        override fun onLongPress(e: MotionEvent) {
            onLongClick()
            super.onLongPress(e)
        }

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

    }

    open fun onClick(){

    }
    open fun onDoubleClick(){

    }
    open fun onLongClick(){

    }
}