package com.example.myapplication.features.calendar.presentation

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale


@Composable
fun CalendarGrid(
    selectedDate: LocalDate,
    onDateChanged: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val today = remember { LocalDate.now() }
    val currentYearMonth = remember(selectedDate) { YearMonth.from(selectedDate) }
    val daysInMonth = currentYearMonth.lengthOfMonth()
    val firstDayOfWeek = currentYearMonth.atDay(1).dayOfWeek.value
    val emptySpacesBeforeFirstDay = firstDayOfWeek - 1
    var showMonthMenu by remember { mutableStateOf(false) }

    val monthsList = remember {
        val formatter = java.time.format.DateTimeFormatter.ofPattern("LLLL", Locale("ru"))
        (1..12).map { monthValue ->
            java.time.LocalDate.of(2026, monthValue, 1)
                .format(formatter)
                .replaceFirstChar { char -> char.uppercase() }
        }
    }
    val currentMonthName = remember(selectedDate) {
        val formatter = java.time.format.DateTimeFormatter.ofPattern("LLLL", Locale("ru"))
        selectedDate.format(formatter).uppercase()
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = {
                val targetMonth = selectedDate.minusMonths(1)
                if (targetMonth.isBefore(today.withDayOfMonth(1))) {
                    Toast.makeText(context, "Нельзя смотреть прошедшие месяцы", Toast.LENGTH_SHORT).show()
                } else {
                    val targetDay = if (targetMonth.year == today.year && targetMonth.month == today.month) today else targetMonth.withDayOfMonth(1)
                    onDateChanged(targetDay)
                }
            }) {
                Text("<", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { showMonthMenu = true }
                ) {
                    Text(
                        text = "$currentMonthName ${selectedDate.year}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(text = " ▾", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
                }

                DropdownMenu(expanded = showMonthMenu, onDismissRequest = { showMonthMenu = false }) {
                    monthsList.forEachIndexed { index, month ->
                        DropdownMenuItem(
                            text = { Text(month) },
                            onClick = {
                                val targetMonthValue = index + 1
                                if (selectedDate.year == today.year && targetMonthValue < today.monthValue) {
                                    Toast.makeText(context, "Этот месяц уже прошел!", Toast.LENGTH_SHORT).show()
                                } else {
                                    showMonthMenu = false
                                    val maxDays = YearMonth.of(selectedDate.year, targetMonthValue).lengthOfMonth()
                                    val safeDay = minOf(selectedDate.dayOfMonth, maxDays)
                                    onDateChanged(selectedDate.withMonth(targetMonthValue).withDayOfMonth(safeDay))
                                }
                            }
                        )
                    }
                }
            }

            TextButton(onClick = {
                val targetMonth = selectedDate.plusMonths(1)
                onDateChanged(targetMonth.withDayOfMonth(1))
            }) {
                Text(">", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс").forEach {
                Text(it, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.outline)
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(emptySpacesBeforeFirstDay) {
                Spacer(modifier = Modifier.aspectRatio(1.2f))
            }

            items(daysInMonth) { index ->
                val dayNumber = index + 1
                val iteratingDate = currentYearMonth.atDay(dayNumber)
                val isRealToday = iteratingDate == today
                val isSelected = iteratingDate == selectedDate
                val isPastDay = iteratingDate.isBefore(today)

                Box(
                    modifier = Modifier
                        .aspectRatio(1.2f)
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent)
                        .then(if (isRealToday) Modifier.border(2.dp, MaterialTheme.colorScheme.error, CircleShape) else Modifier)
                        .clickable {
                            if (isPastDay) {
                                Toast.makeText(context, "Нельзя выбирать прошедшие даты!", Toast.LENGTH_SHORT).show()
                            } else {
                                onDateChanged(iteratingDate)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = dayNumber.toString(),
                        fontSize = 15.sp, // Чуть-чуть уменьшили шрифт для компактности
                        fontWeight = if (isRealToday) FontWeight.Bold else FontWeight.Normal,
                        color = when {
                            isSelected -> MaterialTheme.colorScheme.onPrimary
                            isPastDay -> MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                            isRealToday -> MaterialTheme.colorScheme.error
                            else -> MaterialTheme.colorScheme.onSurface
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EventListView(
    eventsList: List<String>,
    onAddEvent: (String, (Boolean) -> Unit) -> Unit,
    onDeleteEvent: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var newEventText by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    val timePickerDialog = TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            eventTime = String.format("%02d:%02d", selectedHour, selectedMinute)
        },
        hour,
        minute,
        true
    )

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
                newEventText = ""
                eventTime = ""
            },
            title = { Text("Новая задача", fontWeight = FontWeight.Bold) },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { timePickerDialog.show() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (eventTime.isBlank()) "🕒 Выбрать время задачи" else "Выбранное время: $eventTime",
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    OutlinedTextField(
                        value = newEventText,
                        onValueChange = { newEventText = it },
                        label = { Text("Что планируете сделать?") },
                        placeholder = { Text("Введите текст задачи") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val text = newEventText.trim()
                        if (text.isNotEmpty()) {
                            val fullTaskText = if (eventTime.isNotBlank()) {
                                "⏱️ $eventTime — $text"
                            } else {
                                text
                            }

                            onAddEvent(fullTaskText) { success ->
                                if (success) {
                                    showDialog = false
                                    newEventText = ""
                                    eventTime = ""
                                } else {
                                    Toast.makeText(context, "Максимум 3 задачи на один день!", Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                ) {
                    Text("Сохранить")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        newEventText = ""
                        eventTime = ""
                    }
                ) {
                    Text("Отмена")
                }
            }
        )
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Задачи на день:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = { showDialog = true }) {
                Text("Добавить")
            }
        }

        if (eventsList.isEmpty()) {
            Text(
                text = "Задач нет. День свободен! 🎉",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                textAlign = TextAlign.Center
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(eventsList) { index, event ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = event,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { onDeleteEvent(index) }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Удалить задачу",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}