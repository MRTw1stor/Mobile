package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen
import com.example.myapplication.features.blocks.presentation.AdaptiveSectionTabs
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import com.example.myapplication.features.blocks.info.CommunicationHamburger
import com.example.myapplication.features.blocks.info.CommunicationListening
import com.example.myapplication.features.blocks.info.CommunicationTheory

@Composable
fun CommunicationScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Теория 🗣", "Слушание 🧠", "Гамбургер 🍔")

    CatalogBaseScreen(title = "Коммуникация", navController = navController) {
        AdaptiveSectionTabs(
            tabs = tabs,
            selectedTabIndex = selectedTab,
            onTabSelected = { selectedTab = it }
        )
        Spacer(modifier = Modifier.height(12.dp))
        when (selectedTab) {
            0 -> CommunicationTheory()
            1 -> CommunicationListening()
            2 -> CommunicationHamburger()
        }
    }
}