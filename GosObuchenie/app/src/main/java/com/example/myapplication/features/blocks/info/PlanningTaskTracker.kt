package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border


@Composable
fun VisualTaskTracker() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = "Визуальный таск-трекер — это, говоря простыми словами, электронная доска с наклеенными на неё стикерами задач. Вместо длинного и унылого списка дел в блокноте, где всё свалено в кучу, вы видите перед собой наглядную карту вашей работы.",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        TaskTrackerTextCard(
            title = "Как это устроено?",
            content = "Вся ваша работа делится на три простых элемента:\n\n1. Доска — это ваше рабочее пространство (например, «Проекты на лето» или «Мои рабочие задачи»).\n2. Колонки (Этапы) — это шаги, которые проходит любая задача. Самый простой классический вариант:\n   • План (что нужно сделать в будущем).\n   • В работе (чем вы заняты прямо сейчас).\n   • Готово (выполненные дела).\n3. Карточки (Стикеры) — это сами ваши задачи. Например: «Подготовить отчет за июнь». Карточку можно мышкой перетаскивать из колонки в колонку по мере выполнения.",
            accentColor = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Визуальная схема рабочей доски задач:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        FullKanbanBoardVisual()

        Spacer(modifier = Modifier.height(20.dp))

        TaskTrackerTextCard(
            title = "Как это использовать на рабочем месте?",
            content = "Пользоваться таким инструментом очень легко, это занимает 5-10 минут в день:\n\nШаг 1: Выгрузите всё из головы. В начале недели запишите все свои дела в колонку «План». Одна задача — одна карточка.\nШаг 2: Начните работу. Утром выберите одну или две самые важные задачи и перетащите их мышкой в колонку «В работе». Теперь вы четко знаете, на чем сфокусироваться.\nШаг 3: Наполняйте карточки деталями. Кликните на задачу — внутри неё можно написать чек-лист (мини-шаги), прикрепить рабочий документ или поставить дату (дедлайн), когда всё должно быть готово.\nШаг 4: Продвигайте задачу. Как только вы закончили делать отчет, перетащите карточку в колонку «Готово».",
            accentColor = Color(0xFFFF9100)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TaskTrackerTextCard(
            title = "Что это вам дает?",
            content = "• Вы ничего не забудете. Все рабочие задачи, файлы к ним и сроки хранятся в одном месте, а не теряются в рабочих чатах, почте или на клочках бумаги.\n• Вы перестанете хвататься за всё сразу. Когда перед глазами есть колонка «В работе», вы четко видите: «Так, у меня там уже висит 3 дела. Новые задачи я пока брать не буду, сначала доделаю эти». Это спасает от стресса.\n• Вы видите свой прогресс. К концу недели колонка «Готово» будет забита выполненными карточками. Это дает приятное чувство выполненного долга и помогает легко отчитаться перед руководителем о проделанной работе.\n• Полный порядок перед глазами. Достаточно одного взгляда на экран, чтобы мгновенно понять, на каком этапе находится любое ваше рабочее дело.",
            accentColor = Color(0xFF4CAF50)
        )
    }
}

@Composable
fun FullKanbanBoardVisual() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f))
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        // --- КОЛОНКА 1: ПЛАН (Желтые стикеры) ---
        Column(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text("📋 План (4)", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = Color(0xFF9E7D00), modifier = Modifier.padding(horizontal = 2.dp))

            DetailedMiniSticker("Подготовить проект постановления администрации", "🗓️ 10 июл", Color(0xFFFFF59D))
            DetailedMiniSticker("Подготовить ответ на обращение гражданина", "🗓️ 12 июл", Color(0xFFFFF59D))
            DetailedMiniSticker("Разработать изменения в административный регламент", "🗓️ 15 июл", Color(0xFFFFF59D))
            DetailedMiniSticker("Подготовить отчет о исполнении бюджета", "🗓️ 20 июл", Color(0xFFFFF59D))
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text("⚙️ В работе (3)", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(horizontal = 2.dp))

            DetailedMiniSticker("Подготовить проект ответа на запрос контрольного органа", "👤 До, 24 июн", Color(0xFFBBDEFB))
            DetailedMiniSticker("Согласовать проект приказа с юридическим отделом", "👤 До, 25 июн", Color(0xFFBBDEFB))
            DetailedMiniSticker("Провести проверку исполнения поручения главы", "👤 До, 27 июн", Color(0xFFBBDEFB))
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFE8F5E9).copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                .padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text("✅ Готово (4)", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32), modifier = Modifier.padding(horizontal = 2.dp))

            DetailedMiniSticker("Подготовить справку по результатам совещания", "🟢 Вып. 18 июн", Color(0xFFC8E6C9))
            DetailedMiniSticker("Опубликовать информацию на оф. сайте", "🟢 Вып. 17 июн", Color(0xFFC8E6C9))
            DetailedMiniSticker("Подготовить проект муниц. задания", "🟢 Вып. 16 июн", Color(0xFFC8E6C9))
            DetailedMiniSticker("Направить уведомление в налоговый орган", "🟢 Вып. 15 июн", Color(0xFFC8E6C9))
        }
    }
}

@Composable
fun DetailedMiniSticker(taskText: String, footerText: String, stickerColor: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = stickerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(6.dp)) {
            Text(
                text = taskText,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp, lineHeight = 12.sp),
                color = Color(0xFF1A1A1A),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = footerText,
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 8.sp),
                color = Color(0xFF424242),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TaskTrackerTextCard(title: String, content: String, accentColor: Color) {
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
                    .width(4.dp)
                    .background(accentColor)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}