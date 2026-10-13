package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CommunicationHamburger() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {

        Text(
            text = "🍔 Обратная связь: Метод «Гамбургера»",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Метод «гамбургера» (или метод бутерброда) — это классическая трехэтапная техника предоставления обратной связи. Ее суть заключается в том, чтобы упаковать критику между двумя слоями похвалы и позитивных комментариев, снижая психологическую защиту собеседника.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF57C00).copy(alpha = 0.15f)),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp,
                bottomStart = 4.dp,
                bottomEnd = 4.dp
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "🍞 Верхняя булочка (Похвала)",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE65100)
                )
                Text(
                    "Начните с позитива, отметив реальные заслуги, сильные стороны или успехи человека.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Например: «Мне очень понравилась структура твоего отчета, все логично»",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD32F2F).copy(alpha = 0.15f)),
            shape = RoundedCornerShape(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "🥩 Начинка / Котлета (Критика)",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB71C1C)
                )
                Text(
                    "Конструктивно укажите на зоны роста, ошибки или то, что нужно исправить, опираясь исключительно на факты, а не на личности.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Например: «При этом в третьем графике допущена ошибка в расчетах»",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF57C00).copy(alpha = 0.15f)),
            shape = RoundedCornerShape(
                topStart = 4.dp,
                topEnd = 4.dp,
                bottomStart = 24.dp,
                bottomEnd = 24.dp
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "🍞 Нижняя булочка (Поддержка)",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE65100)
                )
                Text(
                    "Завершите разговор на позитивной ноте, выразив уверенность в человеке, предложив помощь или наметив план действий.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Например: «Исправь это до вечера, я уверен, что итоговый вариант будет отличным»",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                    alpha = 0.4f
                )
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Метод Гамбургера помогает экологично и безопасно общаться со своими коллегами, смежными отделами и даже с руководством. С его помощью можно мягко указать коллеге на ошибку в общей задаче, аргументированно отказать в токсичной просьбе или деликатно предложить руководителю идею по улучшению процессов. Это позволяет отстаивать свои границы, сохранять со всеми отличные рабочие отношения и не прослыть конфликтным человеком.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}