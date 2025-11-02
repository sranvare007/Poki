package com.example.remindersapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.remindersapp.data.Reminder
import com.example.remindersapp.data.ReminderDatabase
import com.example.remindersapp.data.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReminderViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ReminderRepository
    val allReminders: StateFlow<List<Reminder>>

    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())

    init {
        val reminderDao = ReminderDatabase.getDatabase(application).reminderDao()
        repository = ReminderRepository(reminderDao)

        viewModelScope.launch {
            repository.allReminders.collect { reminders ->
                _reminders.value = reminders
            }
        }
        allReminders = _reminders.asStateFlow()
    }

    fun addReminder(title: String, description: String, reminderTime: Long) = viewModelScope.launch {
        val reminder = Reminder(
            title = title,
            description = description,
            reminderTime = reminderTime
        )
        val id = repository.insert(reminder)

        // Schedule the alarm
        val alarmScheduler = AlarmScheduler(getApplication())
        alarmScheduler.scheduleAlarm(id.toInt(), reminderTime, title, description)
    }

    fun deleteReminder(reminder: Reminder) = viewModelScope.launch {
        repository.delete(reminder)

        // Cancel the alarm
        val alarmScheduler = AlarmScheduler(getApplication())
        alarmScheduler.cancelAlarm(reminder.id)
    }

    fun updateReminder(reminder: Reminder) = viewModelScope.launch {
        repository.update(reminder)

        // Reschedule the alarm
        val alarmScheduler = AlarmScheduler(getApplication())
        alarmScheduler.scheduleAlarm(reminder.id, reminder.reminderTime, reminder.title, reminder.description)
    }
}
