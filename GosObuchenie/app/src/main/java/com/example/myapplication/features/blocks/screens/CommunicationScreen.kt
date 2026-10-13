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
        ScrollableTabRow(
            selectedTabIndex = selectedTab,
            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title, fontWeight = FontWeight.Bold) }
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        when (selectedTab) {
            0 -> CommunicationTheory()
            1 -> CommunicationListening()
            2 -> CommunicationHamburger()
        }
    }
}