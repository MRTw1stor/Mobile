package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommunicationListening() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {

        Text(
            text = "🧠 Техники активного слушания",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Техники активного слушания — это набор навыков, которые позволяют собеседнику почувствовать, что вы не просто ждете своей очереди высказаться, а действительно понимаете его мысли и эмоции. Главная задача этих приемов — минимизировать искажения информации и устранить барьеры непонимания.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        val listeningTechniques = listOf(
            Triple(
                "1. Активное (открытое) молчание",
                "Проявление заинтересованности невербальными средствами (кивки, зрительный контакт, открытая поза). Это дает собеседнику возможность выговориться и собраться с мыслями.",
                emptyList()
            ),
            Triple(
                "2. Перефразирование (парафраз)",
                "Повторение сути сказанного собеседника своими словами, чтобы убедиться в правильности понимания.",
                listOf("«Правильно ли я понимаю, что...»", "«Иными словами, вы имеете в виду...»")
            ),
            Triple(
                "3. Уточнение",
                "Побуждение собеседника раскрыть детали с помощью открытых вопросов, на которые нельзя ответить односложно.",
                listOf("«Что именно произошло?»", "«Расскажите об этом подробнее»")
            ),
            Triple(
                "4. Отражение эмоций",
                "Озвучивание чувств, которые испытывает говорящий, что помогает ему понять, что его состояние разделяют.",
                listOf("«Я вижу, как вас это расстроило»", "«Должно быть, это было непросто»")
            ),
            Triple(
                "5. Резюмирование",
                "Подведение итогов, объединение основных мыслей и чувств собеседника в единое целое.",
                listOf("«Итак, основные проблемы, которые вы обозначили, это...»")
            )
        )

        listeningTechniques.forEach { (title, desc, examples) ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                        alpha = 0.3f
                    )
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = desc, style = MaterialTheme.typography.bodyMedium)

                    if (examples.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                                    alpha = 0.35f
                                )
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "Примеры речевых модулей:",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                examples.forEach { example ->
                                    Text(
                                        text = example,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(top = 2.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.06f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Зачем это нужно госслужащему? 📋",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Техники активного слушания нужны для того, чтобы защитить себя от лишней работы, ошибок и недопониманий при получении задач от коллег или руководства. Они помогают точно понять ожидания начальника с первого раза, зафиксировать четкие критерии оценки и вовремя заметить скрытые требования в задаче. Кроме того, этот навык защищает сотрудника от манипуляций, помогает быстрее договариваться со смежными отделами и формирует репутацию надежного, вдумчивого профессионала.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 20.sp
                )
            }
        }
    }
}