package com.example.myapplication.features.blocks.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class CatalogViewModel : ViewModel() {
    var expandedBlockId by mutableStateOf<Int?>(null)
        private set
    var isWelcomeExpanded by mutableStateOf(false)
        private set
    var isAdaptationExpanded by mutableStateOf(false)
        private set

    fun toggleBlock(blockId: Int) {
        expandedBlockId = if (expandedBlockId == blockId) null else blockId
        if (expandedBlockId != null) {
            isWelcomeExpanded = false
            isAdaptationExpanded = false
        }
    }

    fun toggleWelcomeBlock() {
        isWelcomeExpanded = !isWelcomeExpanded
        if (isWelcomeExpanded) {
            expandedBlockId = null
            isAdaptationExpanded = false
        }
    }

    fun toggleAdaptationBlock() {
        isAdaptationExpanded = !isAdaptationExpanded
        if (isAdaptationExpanded) {
            expandedBlockId = null
            isWelcomeExpanded = false
        }
    }
}
