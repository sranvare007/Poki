package com.example.remindersapp.data

import kotlinx.coroutines.flow.Flow

class ReminderRepository(private val reminderDao: ReminderDao) {
    val allReminders: Flow<List<Reminder>> = reminderDao.getAllReminders()

    suspend fun insert(reminder: Reminder): Long {
        return reminderDao.insertReminder(reminder)
    }

    suspend fun update(reminder: Reminder) {
        reminderDao.updateReminder(reminder)
    }

    suspend fun delete(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun deleteById(id: Int) {
        reminderDao.deleteReminderById(id)
    }

    suspend fun getReminderById(id: Int): Reminder? {
        return reminderDao.getReminderById(id)
    }
}
