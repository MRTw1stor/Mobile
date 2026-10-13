package com.example.myapplication.features.notes.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.features.notes.components.NoteBlockDialog
import com.example.myapplication.features.notes.components.NoteBlockListContent
import com.example.myapplication.features.notes.components.NoteEditorContent

@Composable
fun NotesScreen(viewModel: NotesViewModel = viewModel()) {
    var showBlockDialog by remember { mutableStateOf(false) }
    var editingBlockId by remember { mutableStateOf<Long?>(null) }
    var blockTitle by remember { mutableStateOf("") }
    var blockDesc by remember { mutableStateOf("") }
    var noteTitle by remember { mutableStateOf("") }
    var noteContent by remember { mutableStateOf("") }
    val currentEditingNote = viewModel.currentEditingNote

    LaunchedEffect(currentEditingNote) {
        if (currentEditingNote != null) {
            val (noteId, _) = currentEditingNote
            if (noteId != null) {
                val existingNote = viewModel.getNoteById(noteId)
                noteTitle = existingNote?.title ?: ""
                noteContent = existingNote?.content ?: ""
            } else {
                noteTitle = ""
                noteContent = ""
            }
        }
    }

    if (currentEditingNote != null) {
        val (noteId, blockId) = currentEditingNote

        NoteEditorContent(
            noteTitle = noteTitle,
            onTitleChange = { noteTitle = it },
            noteContent = noteContent,
            onContentChange = { noteContent = it },
            onBackClick = { viewModel.currentEditingNote = null },
            onSaveClick = {
                viewModel.saveOrUpdateNote(noteId, blockId, noteTitle, noteContent)
                viewModel.currentEditingNote = null
            }
        )
    } else {
        NoteBlockListContent(
            viewModel = viewModel,
            onCreateBlockClick = {
                editingBlockId = null
                blockTitle = ""
                blockDesc = ""
                showBlockDialog = true
            },
            onEditBlockClick = { block ->
                editingBlockId = block.id
                blockTitle = block.title
                blockDesc = block.description
                showBlockDialog = true
            },
            onAddNoteClick = { blockId ->
                viewModel.currentEditingNote = Pair(null, blockId)
            }
        )
    }

    if (showBlockDialog) {
        NoteBlockDialog(
            isEditing = (editingBlockId != null),
            titleValue = blockTitle,
            onTitleChange = { blockTitle = it },
            descriptionValue = blockDesc,
            onDescriptionChange = { blockDesc = it },
            onDismiss = { showBlockDialog = false },
            onConfirm = {
                val currentId = editingBlockId
                if (currentId == null) {
                    viewModel.addBlock(blockTitle, blockDesc)
                } else {
                    viewModel.updateBlock(currentId, blockTitle, blockDesc)
                }
                showBlockDialog = false
            }
        )
    }
}
