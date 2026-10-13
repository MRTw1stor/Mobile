package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen
import com.example.myapplication.core.utils.AnalyticsManager

@Composable
fun RussianLanguageScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    CatalogBaseScreen(title = "Правила языка", navController = navController) {

        Text(
            text = "Официальная переписка, ответы на обращения граждан, подготовка нормативных актов и докладов требуют безупречного владения языком. Любая орфографическая или стилистическая ошибка в официальном документе подрывает авторитет ведомства и снижает уровень доверия граждан к принимаемым решениям. Данная подборка призвана стать вашим ежедневным настольным помощником для оперативной проверки сложных случаев написания и пунктуационного оформления.",
            style = MaterialTheme.typography.bodyMedium,
            lineHeight = 22.sp
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.15f)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(5.dp)
                        .background(
                            color = MaterialTheme.colorScheme.error,
                            shape = RoundedCornerShape(topStart = 2.dp, bottomStart = 2.dp)
                        )
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "💡", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "РЕКОМЕНДАЦИЯ К ОЗНАКОМЛЕНИЮ",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Настоятельно рекомендуем регулярно изучать представленные материалы для постоянного повышения уровня личной грамотности и исключения досадных ошибок в служебных записках и письмах.",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontStyle = FontStyle.Italic,
                            lineHeight = 20.sp
                        ),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Цифровая библиотека 📄",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Ознакомьтесь с полным набором лингвистических памяток. База сложных кейсов и правил деловой переписки регулярно дополняется.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                Button(
                    onClick = {
                        AnalyticsManager.trackLinkClick(
                            linkName = "Перейти к правилам русского языка",
                            url = "https://disk.yandex.ru/d/d_8i5t1sDQt5iA"
                        )
                        uriHandler.openUri("https://disk.yandex.ru/d/d_8i5t1sDQt5iA")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Открыть правила",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
