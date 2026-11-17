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
import androidx.compose.material.icons.filled.Edit
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

    // Keep the calendar at a comfortable maximum width on wide phones and foldables.
    // On narrow phones it still uses the full available width.
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
      Column(
          modifier = Modifier
              .widthIn(max = 480.dp)
              .fillMaxWidth()
      ) {
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
                Spacer(modifier = Modifier.fillMaxWidth().height(44.dp))
            }

            items(daysInMonth) { index ->
                val dayNumber = index + 1
                val iteratingDate = currentYearMonth.atDay(dayNumber)
                val isRealToday = iteratingDate == today
                val isSelected = iteratingDate == selectedDate
                val isPastDay = iteratingDate.isBefore(today)

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .clickable {
                            if (isPastDay) {
                                Toast.makeText(context, "Нельзя выбирать прошедшие даты!", Toast.LENGTH_SHORT).show()
                            } else {
                                onDateChanged(iteratingDate)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent)
                            .then(if (isRealToday) Modifier.border(2.dp, MaterialTheme.colorScheme.error, CircleShape) else Modifier),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = dayNumber.toString(),
                            fontSize = 15.sp,
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
    }
}

private fun taskTimeInMinutes(task: String): Int? {
    val match = Regex("""(?<!\d)([01]\d|2[0-3]):([0-5]\d)(?!\d)""").find(task)
        ?: return null
    val hour = match.groupValues[1].toInt()
    val minute = match.groupValues[2].toInt()
    return hour * 60 + minute
}

@Composable
fun EventListView(
    eventsList: List<String>,
    onAddEvent: (String, (Boolean) -> Unit) -> Unit,
    onDeleteEvent: (Int) -> Unit,
    onUpdateEvent: (Int, String, (Boolean) -> Unit) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var editingEventIndex by remember { mutableStateOf<Int?>(null) }
    var eventText by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }

    fun resetEditor() {
        showDialog = false
        editingEventIndex = null
        eventText = ""
        eventTime = ""
    }

    fun openTimePicker() {
        val now = Calendar.getInstance()
        val initialHour = eventTime.substringBefore(":").toIntOrNull()
            ?: now.get(Calendar.HOUR_OF_DAY)
        val initialMinute = eventTime.substringAfter(":").toIntOrNull()
            ?: now.get(Calendar.MINUTE)
        TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                eventTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute)
            },
            initialHour,
            initialMinute,
            true
        ).show()
    }

    fun openEditor(index: Int?, event: String? = null) {
        editingEventIndex = index
        if (event == null) {
            eventText = ""
            eventTime = ""
        } else {
            val match = Regex("""^\s*(?:⏱️?\s*)?(\d{2}:\d{2})\s*[—-]\s*(.*)$""").matchEntire(event)
            if (match != null) {
                eventTime = match.groupValues[1]
                eventText = match.groupValues[2]
            } else {
                eventTime = ""
                eventText = event
            }
        }
        showDialog = true
    }

    if (showDialog) {
        val isEditing = editingEventIndex != null
        AlertDialog(
            onDismissRequest = { resetEditor() },
            title = {
                Text(
                    if (isEditing) "Редактировать задачу" else "Новая задача",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { openTimePicker() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (eventTime.isBlank()) "🕒 Выбрать время задачи" else "Выбранное время: $eventTime",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    OutlinedTextField(
                        value = eventText,
                        onValueChange = { eventText = it },
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
                        val trimmedText = eventText.trim()
                        if (trimmedText.isNotEmpty()) {
                            val fullTaskText = if (eventTime.isNotBlank()) {
                                "⏱️ $eventTime — $trimmedText"
                            } else {
                                trimmedText
                            }
                            val callback: (Boolean) -> Unit = { success ->
                                if (success) resetEditor()
                                else Toast.makeText(
                                    context,
                                    "Не удалось сохранить задачу. Попробуйте ещё раз.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            val index = editingEventIndex
                            if (index == null) onAddEvent(fullTaskText, callback)
                            else onUpdateEvent(index, fullTaskText, callback)
                        } else {
                            Toast.makeText(context, "Введите описание задачи", Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(if (isEditing) "Сохранить изменения" else "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = { resetEditor() }) { Text("Отмена") }
            }
        )
    }

    // Sort tasks chronologically. Keep original indices so edit/delete affect the right stored item.
    val sortedEvents = remember(eventsList) {
        eventsList.withIndex().sortedWith(
            compareBy<IndexedValue<String>> { taskTimeInMinutes(it.value) ?: Int.MAX_VALUE }
                .thenBy { it.index }
        )
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Задачи на день:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Button(onClick = { openEditor(null) }) { Text("Добавить") }
        }

        if (eventsList.isEmpty()) {
            Text(
                text = "Задач нет. День свободен! 🎉",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
                textAlign = TextAlign.Center
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().heightIn(max = 300.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(sortedEvents) { _, indexedEvent ->
                    val originalIndex = indexedEvent.index
                    val event = indexedEvent.value
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 4.dp, top = 4.dp, bottom = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = event,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f).clickable { openEditor(originalIndex, event) }
                            )
                            IconButton(onClick = { openEditor(originalIndex, event) }) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Редактировать задачу",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                            IconButton(onClick = { onDeleteEvent(originalIndex) }) {
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
