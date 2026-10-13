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
fun TeamworkScreen(navController: NavController) {
    CatalogBaseScreen(
        title = "Командная работа",
        navController = navController
    ) {
        Text(
            text = "👥 Командная работа",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Государственная и муниципальная служба — это всегда коллективный процесс. Здесь практически невозможно выполнить задачу в одиночку: каждый документ, отчет или ответ гражданину создается общими усилиями.\n\nЭтот блок поможет вам быстро и безопасно встроиться в уже сложившийся коллектив. Вы узнаете, как завоевать профессиональное доверие коллег, не отвлекая их от работы, и как с первых дней показывать отличный результат. Мы разберем три простых практических инструмента, которые сделают Ваш старт максимально комфортным.",
            style = MaterialTheme.typography.bodyLarge
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

        Text(
            text = "🗺️ Карта внутренней кухни",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Чтобы понимать, какой коллега в каком вопросе сможет вам помочь, в первые 7–10 дней рекомендуем вам составить для себя личную «карту внутренней кухни». Это ваш персональный навигатор по правилам и экспертам ведомства. Заведите для этого лист в рабочем блокноте или заметках.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))

        val kitchenMethods = listOf(
            "Найдите экспертов" to "Обратите внимание, к кому коллеги чаще всего ходят за советом. Запишите: «Смирнова А.А. — знает всё про согласование у Главы, лучше подходить после 15:00», «Петров И.И. — ас в закупках и сложных таблицах».",
            "Определите смежников" to "Выпишите имена и телефоны сотрудников из соседних отделов, с которыми Ваша команда пересекается чаще всего.",
            "Изучите местные традиции" to "Понаблюдайте и зафиксируйте негласные правила. Как в отделе принято обедать? Как поздравляют с праздниками? Каков реальный дресс-код в дни, когда нет личного приема граждан?"
        )

        kitchenMethods.forEach { (title, desc) ->
            TeamworkCardItem(title = title, desc = desc, indicatorColor = MaterialTheme.colorScheme.primary)
        }

        Text(
            text = "✨ Этот инструмент убережет Вас от блуждания по кабинетам. Вы сможете решать вопросы быстрее, обращаясь напрямую к нужному человеку в правильное время.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

        Text(
            text = "💡 Формула «Я + Решение»",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "На госслужбе очень ценится исполнительность, но самостоятельность ценится вдвойне. Главное правило успешного командного игрока — никогда не приносить руководителю или наставнику проблему в чистом виде. Используйте формулу «Я + Решение». Сначала сформулируйте три предложения по четкой схеме:",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))

        val formulaMethods = listOf(
            "1. «Я» (Что уже сделано)" to "Коротко опишите текущий статус. Пример: «Я подготовил проект ответа гражданину, но смежный отдел не прислал свою часть данных к назначенному сроку».",
            "2. Проблема" to "Зафиксируйте точку сбоя и риски. Пример: «Без их цифр мы завтра завалим официальный дедлайн».",
            "3. Решение" to "Предложите свой конкретный выход из ситуации. Пример: «Я предлагаю сейчас созвониться с их исполнителем напрямую. Если не ответят — отправить промежуточный документ по нашим данным. Подскажите, у нас так принято делать?»."
        )

        formulaMethods.forEach { (title, desc) ->
            TeamworkCardItem(title = title, desc = desc, indicatorColor = MaterialTheme.colorScheme.secondary)
        }

        Text(
            text = "✨ Такой подход сразу выделит Вас на фоне остальных. Вы покажете, что умеете думать, анализировать и бережете время своего руководителя.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

        Text(
            text = "🛡️ Алгоритм «Безопасный прием задачи»",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        Text(
            text = "Классическая ошибка новичка — выслушать поручение, во всем кивнуть головой, а потом сделать много работы, но вообще не то. У руководителя часто нет времени разжевывать детали. Правильно принять задачу с первого раза — это Ваша обязанность. Используйте чек-лист «5 пальцев»:",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))

        val taskMethods = listOf(
            "1. Конечный результат" to "Уточните, в каком виде должен быть итог. Это официальный проект ответа на бланке в системе документооборота или просто краткие тезисы в рабочем чате?",
            "2. Точный дедлайн" to "Выясните конкретные сроки. Пятница — это до 12:00, чтобы руководитель успел посмотреть документ, или строго до конца рабочего дня?",
            "3. Критерии проверки" to "Спросите, на что обратят внимание в первую очередь. Делать упор на свежую статистику за этот год или нужно сравнить показатели с прошлым периодом?",
            "4. Ресурсы и шаблоны" to "Узнайте, где взять базу. Есть ли аналогичный успешный документ за прошлый месяц, который можно взять за образец?",
            "5. Фиксация" to "Обязательно повторите договоренности вслух или отправьте короткое сообщение в чат после разговора: «Иван Иванович, зафиксировал: с меня проект письма по ЖКХ до 16:00 четверга, шаблон взял из общей папки»."
        )

        taskMethods.forEach { (title, desc) ->
            TeamworkCardItem(title = title, desc = desc, indicatorColor = MaterialTheme.colorScheme.tertiary)
        }

        Text(
            text = "✨ Этот алгоритм застрахует Вас от переделок, сбережет Ваши нервы и покажет команде Вашу высокую собранность.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

/**
 * Универсальный компонент карточки с цветным индикатором слева (как в StressScreen)
 */
@Composable
fun TeamworkCardItem(title: String, desc: String, indicatorColor: androidx.compose.ui.graphics.Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            // Боковой цветной индикатор
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .background(indicatorColor)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = indicatorColor,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = desc,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
