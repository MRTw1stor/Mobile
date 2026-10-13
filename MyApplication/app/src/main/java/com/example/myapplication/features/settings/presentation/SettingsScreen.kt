package com.example.myapplication.features.settings.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val avatarName = "user_avatar.jpg"

    val documentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            coroutineScope.launch(Dispatchers.IO) {
                try {
                    context.contentResolver.openInputStream(uri)?.use { inputStream ->
                        val options = BitmapFactory.Options().apply {
                            inSampleSize = 2
                        }
                        val bitmap = BitmapFactory.decodeStream(inputStream, null, options)

                        if (bitmap != null) {
                            val file = File(context.filesDir, avatarName)
                            FileOutputStream(file).use { outputStream ->
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)
                            }

                            withContext(Dispatchers.Main) {
                                viewModel.saveAvatar(uri)
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Настройки", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = Modifier.statusBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            EditableAvatar(
                avatarBitmap = state.avatarBitmap,
                isLoading = state.isLoadingAvatar,
                onClick = {
                    documentLauncher.launch(arrayOf("image/*"))
                }
            )

            Text(
                text = "Нажмите, чтобы изменить фото",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
            )

            HorizontalDivider()

            Text(
                text = "Тема оформления системы",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 16.dp)
            )

            ThemeOptionRow(
                label = "Системная тема",
                isSelected = (state.currentTheme == "system"),
                onClick = { viewModel.updateTheme("system") }
            )
            ThemeOptionRow(
                label = "Светлая тема",
                isSelected = (state.currentTheme == "light"),
                onClick = { viewModel.updateTheme("light") }
            )
            ThemeOptionRow(
                label = "Тёмная тема",
                isSelected = (state.currentTheme == "dark"),
                onClick = { viewModel.updateTheme("dark") }
            )
        }
    }
}
