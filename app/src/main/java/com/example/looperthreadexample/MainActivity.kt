package com.example.looperthreadexample

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val looperThread = ExampleLooperThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    fun startThread(view: View) { looperThread.start() }

    fun stopThread(view: View) { looperThread.looper.quit() }

    fun taskA(view: View) {
        val msg = Message.obtain()
        msg.what = TASK_A
        looperThread.handler.sendMessage(msg)

        /*val threadHandler = Handler(looperThread.looper)
        threadHandler.post {
            for (i in 0..5) {
                Timber.d("run: $i")
                SystemClock.sleep(1000)
            }
        }*/
    }

    fun taskB(view: View) {
        val msg = Message.obtain()
        msg.what = TASK_B
        looperThread.handler.sendMessage(msg)
    }
}