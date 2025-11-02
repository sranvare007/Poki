package com.example.remindersapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val reminderTime: Long, // timestamp in milliseconds
    val isCompleted: Boolean = false
)
