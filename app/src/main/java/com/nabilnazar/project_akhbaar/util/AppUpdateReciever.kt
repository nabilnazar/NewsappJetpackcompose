package com.nabilnazar.project_akhbaar.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AppUpdateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        context?.cacheDir?.deleteRecursively()
    }
}