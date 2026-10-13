package com.example.myapplication.features.notes.presentation

import android.app.Application
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.myapplication.features.notes.model.NoteBlockEntity
import com.example.myapplication.features.notes.model.NoteItemEntity

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("notes_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    var expandedBlockId by mutableStateOf<Long?>(null)
        private set

    var currentEditingNote by mutableStateOf<Pair<Long?, Long>?>(null)

    var blocksList by mutableStateOf<List<NoteBlockEntity>>(emptyList())
        private set

    var notesList by mutableStateOf<List<NoteItemEntity>>(emptyList())
        private set

    init {
        loadData()
    }

    fun toggleBlock(blockId: Long) {
        expandedBlockId = if (expandedBlockId == blockId) null else blockId
    }

    // ИСПРАВЛЕНО: Заменено с subBlockId на blockId
    fun getNotes(blockId: Long): List<NoteItemEntity> {
        return notesList.filter { it.blockId == blockId }
    }

    fun getNoteById(noteId: Long): NoteItemEntity? {
        return notesList.find { it.id == noteId }
    }

    // ================= УПРАВЛЕНИЕ БЛОКАМИ =================

    fun addBlock(title: String, description: String) {
        val newId = System.currentTimeMillis()
        blocksList = blocksList + NoteBlockEntity(id = newId, title = title, description = description, iconEmoji = "📁")
        saveData()
    }

    fun updateBlock(blockId: Long, newTitle: String, newDescription: String) {
        blocksList = blocksList.map {
            if (it.id == blockId) it.copy(title = newTitle, description = newDescription) else it
        }
        saveData()
    }

    fun deleteBlock(blockId: Long) {
        blocksList = blocksList.filter { it.id != blockId }
        // ИСПРАВЛЕНО: Заменено с subBlockId на blockId
        notesList = notesList.filter { it.blockId != blockId }
        saveData()
        if (expandedBlockId == blockId) expandedBlockId = null
    }

    // ================= УПРАВЛЕНИЕ ЗАМЕТКАМИ =================

    fun saveOrUpdateNote(noteId: Long?, blockId: Long, title: String, content: String) {
        if (noteId == null) {
            val newId = System.currentTimeMillis()
            notesList = notesList + NoteItemEntity(newId, blockId, title, content)
        } else {
            notesList = notesList.map {
                if (it.id == noteId) it.copy(title = title, content = content) else it
            }
        }
        saveData()
    }

    fun deleteNote(noteId: Long) {
        notesList = notesList.filter { it.id != noteId }
        saveData()
    }

    // ================= СОХРАНЕНИЕ В ПАМЯТЬ через JSON =================

    private fun saveData() {
        val editor = prefs.edit()
        val blocksJson = gson.toJson(blocksList)
        val notesJson = gson.toJson(notesList)

        editor.putString("key_blocks_json", blocksJson)
        editor.putString("key_notes_json", notesJson)
        editor.apply()
    }

    private fun loadData() {
        try {
            val blocksJson = prefs.getString("key_blocks_json", null)
            val notesJson = prefs.getString("key_notes_json", null)

            if (blocksJson != null) {
                val blockType = object : TypeToken<List<NoteBlockEntity>>() {}.type
                blocksList = gson.fromJson(blocksJson, blockType)
            }

            if (notesJson != null) {
                val noteType = object : TypeToken<List<NoteItemEntity>>() {}.type
                notesList = gson.fromJson(notesJson, noteType)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
