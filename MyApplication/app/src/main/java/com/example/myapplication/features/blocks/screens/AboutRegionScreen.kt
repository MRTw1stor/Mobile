package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen
import com.example.myapplication.features.blocks.info.RegionStatistik
import com.example.myapplication.features.blocks.info.RegionPeople
import com.example.myapplication.features.blocks.info.RegionHistory

@Composable
fun AboutRegionScreen(navController: NavController) {
    var selectedTab by rememberSaveable { mutableStateOf(0) }
    val tabs = listOf("Сведения 📂", "История ⏳", "Гордость 🎖️")

    CatalogBaseScreen(title = "Информация о регионе", navController = navController) {

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
            0 -> RegionStatistik()
            1 -> RegionHistory()
            2 -> RegionPeople()
        }
    }
}