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
fun StressScreen(navController: NavController) {
    CatalogBaseScreen(title = "Стрессоустойчивость", navController = navController) {

        Text(
            text = "🧘 Ресурсы стрессоустойчивости",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Стрессоустойчивость — это способность психики и организма сохранять стабильность, продуктивность и ясный ум при высоких психологических нагрузках, а также быстро восстанавливаться после потрясений. Это не отсутствие эмоций, а навык гибкого управления своим состоянием без вреда для здоровья.\n\nНиже приведены конкретные методы развития этого навыка, разделенные на экстренную помощь и долгосрочную профилактику.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "🚨 1. Снятие стресса «в моменте» (Экстренные техники)",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.error
        )
        Text(
            text = "Эти методы активируют парасимпатическую нервную систему. Они помогают быстро снизить уровень кортизола и адреналина, когда стресс уже случился.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        val emergencyMethods = listOf(
            "Дыхание «по квадрату»" to "Вдох на 4 счета, задержка на 4, выдох на 4, задержка на 4. Повторяйте 3–5 минут.",
            "Техника заземления «5-4-3-2-1»" to "Найдите глазами 5 предметов, потрогайте 4 текстуры, услышьте 3 звука, почувствуйте 2 запаха, ощутите 1 вкус.",
            "Физический сброс" to "Сделайте 20 приседаний, интенсивно потрясите кистями рук или поочередно сильно сожмите и расслабьте все мышцы тела.",
            "Умывание холодной водой" to "Опустите лицо в прохлавную воду на 10 секунд для включения «нырятельного рефлекса», который замедляет пульс.",
            "Дистанцирование" to "Мысленно посмотрите на ситуацию из будущего. Спросите себя: «Будет ли это важно через 5 лет?»."
        )

        emergencyMethods.forEach { (title, desc) ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    // Красный индикатор слева для экстренных мер
                    Box(
                        modifier = Modifier.fillMaxHeight().width(4.dp)
                            .background(MaterialTheme.colorScheme.error)
                    )

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = desc, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "🌱 2. Профилактика стресса (Долгосрочная стратегия)",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Эти действия повышают общую емкость вашей нервной системы. Они помогают спокойнее реагировать на будущие раздражители.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        val preventiveMethods = listOf(
            "Гигиена сна" to "Засыпайте до 23:00 в полной темноте и прохладе для выработки мелатонина.",
            "Регулярный спорт" to "Занимайтесь кардионагрузками 3 раза в неделю для естественного сжигания излишков стрессовых гормонов.",
            "Информационный детокс" to "Полностью отключайте уведомления в гаджетах минимум за 1 час до сна и на первые 30 минут после пробуждения.",
            "Планирование буферов" to "Оставляйте в ежедневном расписании 15–20% свободного времени на случай непредвиденных задач или отдыха.",
            "Дневник эмоций" to "Ежедневно выписывайте на бумагу свои тревоги и страхи. Это помогает перевести их из зоны паники в зону контроля."
        )

        preventiveMethods.forEach { (title, desc) ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    // Зеленый индикатор для долгосрочной стратегии
                    Box(
                        modifier = Modifier.fillMaxHeight().width(4.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = desc, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
