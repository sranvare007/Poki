# Reminders App

A modern Android reminder application built with Jetpack Compose that allows users to create, manage, and receive notifications for their reminders.

## Features

- Create reminders with title, description, and scheduled time
- Receive notifications at the scheduled time
- View all active reminders in a list
- Delete reminders when no longer needed
- Persistent local storage of reminders
- Works even when the device is in Doze mode

## Tech Stack & Components

### UI Layer
- **Jetpack Compose** - Modern declarative UI toolkit
- **Material 3** - Latest Material Design components and theming
- **Material Icons Extended** - Comprehensive icon library

### Architecture
- **MVVM (Model-View-ViewModel)** - Clean architecture pattern
- **StateFlow** - Reactive state management
- **Coroutines** - Asynchronous operations

### Data Layer
- **Room Database** - Local data persistence
  - `ReminderDao` - Database access object
  - `ReminderDatabase` - Database instance
  - `ReminderRepository` - Data repository pattern
  - `Reminder` - Data entity model

### Background Processing
- **AlarmManager** - Scheduling reminder notifications
- **AlarmScheduler** - Alarm scheduling utility
- **AlarmReceiver** - Broadcast receiver for alarm events
- **NotificationHelper** - Notification creation and display

### Key Components

#### Core Files
- `MainActivity.kt` - App entry point with permission handling
- `ReminderViewModel.kt` - Business logic and state management
- `RemindersScreen.kt` - Main UI screen
- `AddReminderDialog.kt` - Dialog for creating new reminders

#### Data Models
- `Reminder.kt` - Reminder entity with Room annotations

#### Background Services
- `AlarmScheduler.kt` - Schedules and cancels alarms
- `AlarmReceiver.kt` - Handles alarm triggers
- `NotificationHelper.kt` - Manages notification display

## Requirements

- Android SDK 24+
- Target SDK 36
- Kotlin 2.0+

## Permissions

- `POST_NOTIFICATIONS` - For showing notifications (Android 13+)
- `SCHEDULE_EXACT_ALARM` - For precise alarm scheduling
- `USE_EXACT_ALARM` - For exact alarm usage

## Build

This project uses Gradle with Kotlin DSL. To build the project:

```bash
./gradlew build
```

To install on a device:

```bash
./gradlew installDebug
```
