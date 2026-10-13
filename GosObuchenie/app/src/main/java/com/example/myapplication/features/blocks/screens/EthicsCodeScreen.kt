package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun EthicsCodeScreen(navController: NavController) {
    CatalogBaseScreen(title = "Кодекс этики", navController = navController) {

        Text(
            text = "📜 Корпоративная культура и стандарты",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Кодекс этики определяет ключевые принципы взаимодействия внутри нашей команды, стандарты общения с клиентами и партнерами.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(8.dp))

        val ethicsRules = listOf(
            "Взаимное уважение" to "Равное отношение ко всем сотрудникам вне зависимости от должности, поддержка идей коллег и конструктивное обсуждение любых споров.",
            "Профессионализм" to "Честность в выполнении обязанностей, соблюдение дедлайнов, открытость к обратной связи.",
            "Конфиденциальность" to "Защита личных данных сотрудников, коммерческой тайны организации и информации о клиентах от разглашения.",
            "Экологичность решений" to "Принятие решений с учетом долгосрочных интересов всей команды и недопущение личных конфликтов на рабочем месте."
        )

        ethicsRules.forEach { (title, desc) ->
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
