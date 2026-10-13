package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Rule135() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = "Правило «1-3-5» — это один из самых простых и эффективных методов ежедневного планирования. Его главная цель — избавить вас от бесконечных списков дел, которые физически невозможно выполнить за один день, и уберечь от вечернего чувства вины за «ничегонеуспевание». Суть метода в том, что вы жестко ограничиваете количество задач на день до девяти, распределяя их по масштабу и значимости.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Из чего состоит день по правилу «1-3-5»",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Каждое утро (или с вечера) вы формируете список строго по следующей структуре:",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        Rule135StepCard(
            number = "1",
            title = "Одна крупная и важная задача",
            description = "Это главное дело дня. Оно требует больше всего времени (обычно от 1.5 до 3 часов), высокой концентрации и энергии. Выполнение этой задачи двигает вашу работу вперед сильнее всего.\n\n📌 Пример: Написать аналитический отчет за прошлый месяц.",
            accentColor = Color(0xFFFF1744)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Rule135StepCard(
            number = "3",
            title = "Три средние задачи",
            description = "Это важные текущие дела, которые нужно сделать сегодня, но они не требуют пиковых усилий. На каждое уходит примерно по 30–60 минут. Если вы не успеете сделать одно из них, катастрофы не случится — его можно перенести на завтра.\n\n📌 Примеры: Посетить плановый созвон с руководителем; подготовить презентацию для пятничного совещания; разобрать накопившиеся документы на подпись.",
            accentColor = Color(0xFFFF9100)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Rule135StepCard(
            number = "5",
            title = "Пять мелких задач",
            description = "Это рабочая рутина, бытовые вопросы и быстрые дела, которые занимают от 5 до 15 минут. Их часто делают в перерывах между крупными блоками работы, когда мозг устал.\n\n📌 Примеры: Отправить скан договора; ответить на письмо; организовать сбор канцелярии; согласовать дату отпуска с руководителем; почистить рабочий стол от ненужных бумаг.",
            accentColor = Color(0xFF00E676)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Как правильно использовать метод?",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f))
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "✔️ 1. Начинайте с главного: Старайтесь закрыть «1 главную задачу» в первой половине дня, пока у вас свежая голова и вас еще не успели завалить текущими вопросами. Как только вы её сделали — программа-минимум на день выполнена.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "✔️ 2. Не жульничайте с цифрами: Нельзя написать две «главные» задачи или четыре «средние». Если у вас две крупные задачи, выберите одну, а вторую либо запишите в «средние» (разбив её на части), либо перенесите на завтра.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "✔️ 3. Оставляйте пустые места: Не обязательно заполнять все 5 мелких позиций с утра. Оставьте пару строчек пустыми. В течение дня обязательно «прилетит» какая-то мелкая рутина от коллег или руководства — туда вы её и запишете.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Что дает этот инструмент?",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f))
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "• Жесткий фокус: Вы точно знаете, за что хвататься утром. Больше нет паники перед списком из 30 пунктов.", style = MaterialTheme.typography.bodyMedium)
                Text(text = "• Реалистичность: Выполнить 9 понятных задач за 8-часовой рабочий день — абсолютно реально. Метод учитывает, что ваши ресурсы и время ограничены.", style = MaterialTheme.typography.bodyMedium)
                Text(text = "• Психологический комфорт: Вычеркивая вечером последнюю мелкую задачу, вы уходите домой с четким ощущением: «Я сегодня отлично поработал и всё успел», вместо привычного «Опять половину дел переносить на завтра».", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun Rule135StepCard(number: String, title: String, description: String, accentColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(48.dp)
                    .background(accentColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Column(modifier = Modifier.padding(16.dp).weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
