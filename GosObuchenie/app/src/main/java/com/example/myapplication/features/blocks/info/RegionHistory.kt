package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.myapplication.features.blocks.model.InfoCard

@Composable
fun RegionHistory() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "История и наследие края",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "🏰",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Text(
            text = "Добро пожаловать в исторический путеводитель нашего региона. Каждая страница здесь — это летопись мужества, трудовых свершений и богатой культуры. Познакомьтесь ближе с городами и поселениями, которые сформировали уникальный облик и великое наследие нашей родной земли.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 20.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        regionHistoryList.forEach { item ->
            val formattedDescription = buildString {
                append(item.description)
                append("\n\n")

                append("🛡️ Титулы:")
                item.titles.forEach { title ->
                    append("\n  • $title")
                }

                append("\n\n")
                append("📜 Основание назначения:")
                item.orders.forEach { order ->
                    append("\n  • $order")
                }
            }

            InfoCard(
                title = item.title,
                description = formattedDescription,
                accentColor = MaterialTheme.colorScheme.primary,
                imageModifier = Modifier
                    .width(85.dp)
                    .height(115.dp)
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}