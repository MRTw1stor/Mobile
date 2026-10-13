package com.example.myapplication.features.calendar.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import java.time.LocalDate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.myapplication.features.calendar.data.CalendarRepository
import com.example.myapplication.features.calendar.data.CalendarRepositoryImpl
import com.example.myapplication.features.calendar.data.DateKeyFormatter

class CalendarViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CalendarRepository = CalendarRepositoryImpl(application.applicationContext)
    private val _uiState = MutableStateFlow(CalendarState())
    val uiState: StateFlow<CalendarState> = _uiState.asStateFlow()

    init {
        loadEventsForSelectedDate()
    }

    fun onDateSelected(date: LocalDate) {
        _uiState.update { it.copy(selectedDate = date) }
        loadEventsForSelectedDate()
    }

    /**
     * Загрузка списка дел через Репозиторий
     */

    fun loadEventsForSelectedDate() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val dateKey = DateKeyFormatter.getIsoKey(_uiState.value.selectedDate)
            val events = repository.getEventsForDate(dateKey)
            _uiState.update { it.copy(currentEvents = events, isLoading = false) }
        }
    }

    /**
     * Добавление новой задачи
     * Лямбда onResult возвращает true при успешном добавлении, false если достигнут лимит
     */

    fun addEvent(eventText: String, onResult: (Boolean) -> Unit) {
        if (eventText.trim().isEmpty()) {
            onResult(false)
            return
        }

        viewModelScope.launch {
            val dateKey = DateKeyFormatter.getIsoKey(_uiState.value.selectedDate)
            val isAdded = repository.addEventForDate(dateKey, eventText.trim())
            if (isAdded) {
                loadEventsForSelectedDate()
            }
            onResult(isAdded)
        }
    }

    /**
     * Удаление задачи по её индексу
     */

    fun deleteEvent(index: Int) {
        viewModelScope.launch {
            val dateKey = DateKeyFormatter.getIsoKey(_uiState.value.selectedDate)
            repository.deleteEventForDate(dateKey, index)
            loadEventsForSelectedDate()
        }
    }
}
