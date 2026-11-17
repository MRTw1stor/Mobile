package com.example.myapplication.features.blocks.presentation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Адаптивные вкладки: на широком экране равномерно занимают всю ширину,
 * на узком остаются прокручиваемыми, чтобы подписи не сжимались.
 */
@Composable
fun AdaptiveSectionTabs(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val rowModifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
    val background = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)

    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        if (maxWidth >= 420.dp) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = rowModifier,
                containerColor = background
            ) {
                SectionTabItems(tabs, selectedTabIndex, onTabSelected)
            }
        } else {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp,
                modifier = rowModifier,
                containerColor = background
            ) {
                SectionTabItems(tabs, selectedTabIndex, onTabSelected)
            }
        }
    }
}

@Composable
private fun SectionTabItems(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    tabs.forEachIndexed { index, title ->
        Tab(
            selected = selectedTabIndex == index,
            onClick = { onTabSelected(index) },
            text = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    maxLines = 1,
                    softWrap = false
                )
            }
        )
    }
}
