package com.example.looperthreadexample

import android.os.Handler
import android.os.Message
import timber.log.Timber

class ExampleHandler : Handler() {

    override fun handleMessage(msg: Message) {
        when (msg.what) {
            TASK_A -> {
                Timber.d("TASK_A executed")
            }
            TASK_B -> {
                Timber.d("TASK_B executed")
            }
        }
    }
}