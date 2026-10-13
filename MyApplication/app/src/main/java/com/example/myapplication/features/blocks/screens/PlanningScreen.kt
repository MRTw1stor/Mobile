package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.info.EisenhowerMatrix
import com.example.myapplication.features.blocks.info.Rule135
import com.example.myapplication.features.blocks.info.VisualTaskTracker
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun PlanningScreen(navController: NavController) {
    var selectedTab by rememberSaveable { mutableStateOf(0) }
    val tabs = listOf("Матрица 📊", "Таск-трекер ⏱️", "1-3-5 📝")

    CatalogBaseScreen(title = "Планирование времени", navController = navController) {
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
            0 -> EisenhowerMatrix()
            1 -> VisualTaskTracker()
            2 -> Rule135()
        }
    }
}