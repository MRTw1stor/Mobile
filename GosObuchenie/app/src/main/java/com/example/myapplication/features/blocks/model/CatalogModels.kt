package com.example.myapplication.features.blocks.model

import androidx.compose.ui.graphics.Color

data class MainBlock(
    val id: Int,
    val title: String,
    val subtitle: String,
    val subBlocks: List<SubBlock>
)

data class SubBlock(
    val title: String,
    val description: String,
    val route: String,
    val accentColor: Color,
    val iconEmoji: String
)