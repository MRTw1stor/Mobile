package com.example.myapplication.features.dashboard

import android.Manifest
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.time.LocalDate
import java.util.Calendar
import com.example.myapplication.features.calendar.data.CalendarRepositoryImpl
import com.example.myapplication.features.calendar.presentation.CalendarScreen
import com.example.myapplication.features.calendar.data.DateKeyFormatter
import com.example.myapplication.features.notes.presentation.NotesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val avatarName = "user_avatar.jpg"
    var avatarBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var selectedTab by remember { mutableStateOf(0) }
    var showNotificationDialog by remember { mutableStateOf(false) }
    var isBadgeDismissed by remember { mutableStateOf(false) }
    var todayEvents by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val file = File(context.filesDir, avatarName)
            if (file.exists()) {
                try {
                    avatarBitmap = BitmapFactory.decodeFile(file.absolutePath)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (!isGranted) Toast.makeText(context, "Без уведомлений можно пропустить задачи!", Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    val todayKey = remember { DateKeyFormatter.getIsoKey(LocalDate.now()) }

    LaunchedEffect(todayKey, showNotificationDialog) {
        val repository = CalendarRepositoryImpl(context)
        todayEvents = repository.getEventsForDate(todayKey)
    }

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                                .clickable { navController.navigate("settings") },
                            contentAlignment = Alignment.Center
                        ) {
                            if (avatarBitmap != null) {
                                Image(
                                    bitmap = avatarBitmap!!.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, modifier = Modifier.fillMaxSize(0.85f))
                            }
                        }
                    },
                    title = {
                        Text(
                            text = "${getGreetingMessage()}!",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable { navController.navigate("settings") }
                        )
                    },
                    actions = {
                        val showBadge = todayEvents.isNotEmpty() && !showNotificationDialog && !isBadgeDismissed
                        Box(modifier = Modifier.padding(end = 16.dp)) {
                            BadgedBox(
                                badge = {
                                    if (showBadge) {
                                        Badge(containerColor = Color.Red) { Text(todayEvents.size.toString(), fontSize = 11.sp) }
                                    }
                                }
                            ) {
                                IconButton(onClick = { showNotificationDialog = true }) { Icon(Icons.Default.Notifications, null) }
                            }
                        }
                    }
                )
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
            }
        },
        bottomBar = {
            Column {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                NavigationBar {
                    NavigationBarItem(selected = selectedTab == 0, onClick = { selectedTab = 0 }, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Лента") })
                    NavigationBarItem(selected = selectedTab == 1, onClick = { selectedTab = 1 }, icon = { Icon(Icons.Default.DateRange, null) }, label = { Text("Календарь") })
                    NavigationBarItem(selected = selectedTab == 2, onClick = { selectedTab = 2 }, icon = { Icon(Icons.Default.EditNote, null) }, label = { Text("Заметки") })
                }
            }
        }
    )
    { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when (selectedTab) {
                0 -> CatalogListView(navController = navController)
                1 -> CalendarScreen(navController = navController)
                2 -> NotesScreen()
            }
        }
    }

    if (showNotificationDialog) {
        EventsDialog(events = todayEvents, onDismiss = { showNotificationDialog = false; isBadgeDismissed = true })
    }
}

@Composable
private fun EventsDialog(events: List<String>, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("События на сегодня", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                if (events.isEmpty()) {
                    Text("У вас нет запланированных мероприятий на сегодня.")
                } else {
                    events.forEach { event ->
                        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                            Text(text = event, modifier = Modifier.padding(12.dp), fontSize = 15.sp)
                        }
                    }
                }
            }
        },
        confirmButton = { Button(onClick = onDismiss) { Text("Закрыть") } }
    )
}

private fun getGreetingMessage(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 4..11 -> "Доброе утро"
        in 12..16 -> "Добрый день"
        in 17..22 -> "Добрый вечер"
        else -> "Доброй ночи"
    }
}
