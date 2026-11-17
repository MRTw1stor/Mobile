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
import com.example.myapplication.features.blocks.presentation.AdaptiveSectionTabs
import com.example.myapplication.features.blocks.info.RegionStatistik
import com.example.myapplication.features.blocks.info.RegionPeople
import com.example.myapplication.features.blocks.info.RegionHistory

@Composable
fun AboutRegionScreen(navController: NavController) {
    var selectedTab by rememberSaveable { mutableStateOf(0) }
    val tabs = listOf("Сведения 📂", "История ⏳", "Гордость 🎖️")

    CatalogBaseScreen(title = "Информация о регионе", navController = navController) {

        AdaptiveSectionTabs(
            tabs = tabs,
            selectedTabIndex = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(12.dp))

        when (selectedTab) {
            0 -> RegionStatistik()
            1 -> RegionHistory()
            2 -> RegionPeople()
        }
    }
}