package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun ValuesScreen(navController: NavController) {
    CatalogBaseScreen(title = "Ценности", navController = navController) {

        Text(
            text = "💎 Корпоративные ценности и ориентиры",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Ценности команды — это ориентиры, на основе которых мы принимаем ежедневные решения, строим рабочие процессы и оцениваем вклад каждого сотрудника.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Система ценностей :",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        ValueCategorySection(
            categoryTitle = "Личные ценности",
            bgColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            textColor = MaterialTheme.colorScheme.onSurface,
            items = listOf(
                "Честность" to "Отказ от коррупционных схем, декларирование доходов.",
                "Самоконтроль" to "Соблюдение этики в нерабочее время (например, поведение в соцсетях).",
                "Стрессоустойчивость" to "Работа в условиях высокой ответственности и публичного контроля.",
                "Баланс работы и жизни" to "Недопущение переработки в ущерб здоровью."
            )
        )

        ValueCategorySection(
            categoryTitle = "Профессиональные ценности",
            bgColor = Color(0xFF1E88E5).copy(alpha = 0.15f),
            textColor = Color(0xFF1565C0),
            items = listOf(
                "Законность" to "Безукоризненное соблюдение регламентов и нормативных актов.",
                "Профессионализм и компетентность" to "Постоянное обучение и повышение квалификации.",
                "Объективность и беспристрастность" to "Отказ от личных знакомств при назначениях.",
                "Клиентоориентированность" to "Упрощение процедур для граждан (электронные услуги)."
            )
        )

        ValueCategorySection(
            categoryTitle = "Общественные ценности",
            bgColor = Color(0xFFD32F2F).copy(alpha = 0.15f),
            textColor = Color(0xFFC62828),
            items = listOf(
                "Служение обществу" to "Приоритет общественных интересов над личными.",
                "Справедливость" to "Равный доступ к госуслугам для всех категорий граждан.",
                "Прозрачность" to "Публикация отчетов о расходовании бюджетных средств.",
                "Толерантность" to "Учет культурных и социальных особенностей граждан."
            )
        )
    }
}

@Composable
private fun ValueCategorySection(
    categoryTitle: String,
    bgColor: Color,
    textColor: Color,
    items: List<Pair<String, String>>
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = categoryTitle, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = textColor)
            Spacer(modifier = Modifier.height(8.dp))
            items.forEach { (valueName, example) ->
                Column(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text(text = "• $valueName", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyLarge)
                    Text(text = example, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(start = 12.dp))
                }
            }
        }
    }
}
