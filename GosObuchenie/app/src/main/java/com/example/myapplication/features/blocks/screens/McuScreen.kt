package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.core.utils.AnalyticsManager
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun McuScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    val links = listOf(
        Triple(
            "Канал Губернатора Калужской области в мессенджере Max",
            "https://max.ru",
            "max.ru/Shapsha_VV"
        ),
        Triple(
            "Канал Правительства Калужской области в мессенджере Max",
            "https://max.ru",
            "max.ru/pravitelstvo40"
        ),
        Triple(
            "Портал органов власти Калужской области",
            "http://admoblkaluga.ru",
            "admoblkaluga.ru"
        ),
        Triple(
            "Телефонный справочник органов власти Калужской области",
            "https://admoblkaluga.ru/phonebook/",
            "admoblkaluga.ru"
        )
    )

    CatalogBaseScreen(title = "Информационные каналы", navController = navController) {

        Text(
            text = "Полезные ссылки 🔗",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Для оперативного получения проверенной информации, мониторинга актуальной повестки региона и использования в ежедневной служебной деятельности рекомендуем сохранить официальные цифровые ресурсы Калужской области:",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        links.forEach { (name, url, label) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF00A652).copy(alpha = 0.08f)
                )
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(4.dp)
                            .background(Color(0xFF00A652))
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Официальный адрес: $label",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                AnalyticsManager.trackLinkClick(linkName = name, url = url)
                                uriHandler.openUri(url)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF00A652),
                                contentColor = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Перейти на ресурс", fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    }
}
