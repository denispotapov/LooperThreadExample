package com.example.looperthreadexample

import android.os.Handler
import android.os.Looper
import timber.log.Timber

class ExampleLooperThread : Thread() {

    lateinit var handler: Handler
    lateinit var looper: Looper

    override fun run() {
        Looper.prepare()
        looper = Looper.myLooper()!!

        handler = ExampleHandler()
        Looper.loop()
        Timber.d("End of run()")
    }
}