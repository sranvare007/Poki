package com.example.remindersapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val reminderId = intent.getIntExtra("REMINDER_ID", 0)
        val title = intent.getStringExtra("REMINDER_TITLE") ?: "Reminder"
        val description = intent.getStringExtra("REMINDER_DESCRIPTION") ?: ""

        // Show notification with sound
        val notificationHelper = NotificationHelper(context)
        notificationHelper.showNotification(reminderId, title, description)
    }
}
