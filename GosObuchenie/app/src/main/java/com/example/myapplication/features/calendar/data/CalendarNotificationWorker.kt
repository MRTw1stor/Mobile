package com.example.myapplication.features.calendar.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import java.time.LocalDate

/**
 * Фоновый обработчик [CalendarNotificationWorker] на базе WorkManager.
 * Выполняется в фоне ОС Android, даже если приложение закрыто.
 */
class CalendarNotificationWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val repository: CalendarRepository = CalendarRepositoryImpl(context)

    override suspend fun doWork(): Result {
        if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return Result.success()
        }

        val todayKey = DateKeyFormatter.getIsoKey(LocalDate.now())
        val todayEvents = repository.getEventsForDate(todayKey)

        if (todayEvents.isNotEmpty()) {
            sendSystemNotification(todayEvents)
        }

        return Result.success()
    }

    /**
     * Сборка и отправка нативного системного уведомления Android
     */

    private fun sendSystemNotification(events: List<String>) {
        val channelId = "calendar_events_channel"
        val notificationId = 101

        val launchIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)?.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = launchIntent?.let { intent ->
            PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Напоминания о событиях"
            val descriptionText = "Уведомления о запланированных делах в календаре"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val textTitle = "План на сегодня 📅"
        val textContent = if (events.size == 1) {
            events.first()
        } else {
            "${events.first()} (и еще ${events.size - 1} задач)"
        }

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(textTitle)
            .setContentText(textContent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        pendingIntent?.let {
            builder.setContentIntent(it)
        }

        try {
            NotificationManagerCompat.from(context).notify(notificationId, builder.build())
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}
