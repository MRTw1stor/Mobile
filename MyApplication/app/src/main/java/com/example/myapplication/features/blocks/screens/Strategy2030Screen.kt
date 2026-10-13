package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.core.utils.AnalyticsManager
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun Strategy2030Screen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    CatalogBaseScreen(title = "Стратегия 2030", navController = navController) {

        Text(
            text = "🚀 Главное из стратегии развития Калужской области 2030",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Главная миссия региона-предпринимателя — продолжать традицию лидерства, внедряя эффективные инструменты для развития территории и повышения качества жизни людей.",
            style = MaterialTheme.typography.bodyLarge
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.08f
                )
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Официальный источник 📄",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    "Ознакомьтесь с полным текстом нормативного акта долгосрочного социально-экономического развития Калужской области.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                Button(
                    onClick = {
                        AnalyticsManager.trackLinkClick(
                            linkName = "Открыть полную Стратегию на Яндекс.Диске",
                            url = "https://disk.yandex.ru/i/rBkNhBBvLmQejA"
                        )
                        uriHandler.openUri("https://disk.yandex.ru/i/rBkNhBBvLmQejA")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Открыть полную Стратегию")
                }
            }
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

        Text(
            "Главный вектор: Человек — центр инвестиций",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        val strategyPoints = listOf(
            "Главная цель" to "Инвестиции в человека: его образование, здоровье, комфорт проживания и качество среды. Это основа долгосрочной конкурентоспособности Калужской области.",
            "Высокие стандарты жизни" to "Создание среды с высокими стандартами: современное жильё, развитая социальная инфраструктура, экологическая безопасность, доступ к передовой медицине.",
            "Инновационная инфраструктура" to "Технопарки и венчурные фонды нацелены на поддержку людей: молодых учёных, инновационных менеджеров и предпринимателей. Создаются условия для генерации идей.",
            "Человеческий капитал" to "Развитие здравоохранения (научно-медицинский центр радиационной медицины), культуры, туризма и спорта как необходимое условие привлечения талантов."
        )

        strategyPoints.forEach { (title, desc) ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    Box(
                        modifier = Modifier.fillMaxHeight().width(4.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = desc, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
