package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CommunicationTheory() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = "🗣️ Эффективная коммуникация",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Эффективная коммуникация отличается от обычного общения тем, что она целенаправлена и измерима. Главная цель такого взаимодействия — донести информацию без искажений и получить конкретную, ожидаемую обратную связь.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ключевые различия между этими понятиями:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = Modifier.height(4.dp))

        val communicationDiffs = listOf(
            "1. Наличие цели" to (
                    "В обычном общении процесс ради процесса (обмен эмоциями, разговор «по душам»)." to
                            "Эффективная коммуникация всегда решает конкретную задачу."
                    ),
            "2. Ясность и структура" to (
                    "Обычное общение может быть спонтанным и хаотичным." to
                            "В коммуникации информация фильтруется и подается структурированно — используется язык фактов и аргументов."
                    ),
            "3. Обратная связь" to (
                    "Обычное общение удовлетворяет потребность во внимании." to
                            "Эффективная коммуникация проверяется тем, понял ли собеседник мысль и совершил ли нужные действия."
                    ),
            "4. Фокус на аудитории" to (
                    "В бытовом общении люди чаще говорят с позиции «я»." to
                            "При эффективном взаимодействии учитываются потребности и особенности слушателя, его культурный код и опыт."
                    )
        )

        communicationDiffs.forEach { (title, content) ->
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
                        Text(
                            text = "❌ Обычное: ${content.first}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "✅ Эффективное: ${content.second}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}