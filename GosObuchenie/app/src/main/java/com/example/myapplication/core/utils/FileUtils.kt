package com.example.myapplication.core.utils

import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

/**
 * Утилитарный синглтон [FileUtils] для безопасной работы с файловой системой Android.
 * Инкапсулирует логику копирования медиафайлов во внутреннее изолированное хранилище приложения.
 */
object FileUtils {

    /**
     * Копирует файл из внешней среды (например, галереи) во внутреннюю память приложения.
     * Выполняется асинхронно в фоновом потоке, предотвращая зависание интерфейса.
     *
     * @param context Контекст приложения.
     * @param uri Уникальный идентификатор ресурса (Uri) из фото-пикера.
     * @param customFileName Если передано, файл сохранится под этим именем (например, "user_avatar.jpg").
     *                       Если null, сгенерируется уникальное случайное имя (UUID).
     * @return Абсолютный строковый путь к созданному локальному файлу, либо null в случае ошибки.
     */

    suspend fun saveImageToInternalStorage(
        context: Context,
        uri: Uri,
        customFileName: String? = null
    ): String? {
        return withContext(Dispatchers.IO) {
            try {
                val inputStream = context.contentResolver.openInputStream(uri) ?: return@withContext null
                val finalFileName = if (customFileName != null) {
                    customFileName
                } else {
                    val extension = context.contentResolver.getType(uri)?.let { mimeType ->
                        MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)
                    } ?: "jpg"

                    "${UUID.randomUUID()}.$extension"
                }

                val outputFile = File(context.filesDir, finalFileName)
                val outputStream = FileOutputStream(outputFile)

                inputStream.use { input ->
                    outputStream.use { output ->
                        input.copyTo(output)
                    }
                }

                outputFile.absolutePath
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}
