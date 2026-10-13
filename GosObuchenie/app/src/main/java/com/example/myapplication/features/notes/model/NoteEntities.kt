package com.example.myapplication.features.notes.model

/**
 * 1. Главный интерактивный блок-категория заметок
 */

data class NoteBlockEntity(
    val id: Long,
    val title: String,
    val description: String,
    val iconEmoji: String = ""
)

/**
 * 2. Текстовая заметка, привязанная напрямую к главному блоку
 */

data class NoteItemEntity(
    val id: Long,
    val blockId: Long,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)
