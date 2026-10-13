package com.example.myapplication.features.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogViewModel
import com.example.myapplication.features.blocks.presentation.ExpandableBlockCard
import com.example.myapplication.features.blocks.model.SubBlock
import com.example.myapplication.features.blocks.model.MainBlock

@Composable
fun CatalogListView(
    navController: NavController,
    viewModel: CatalogViewModel = viewModel()
) {
    val catalogBlocks = remember { getCatalogStructure() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Общая информация 🏛️",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            val welcomeBlock = remember {
                MainBlock(
                    id = 0,
                    title = "О регионе и ресурсах",
                    subtitle = "Приветственная речь, цифровые каналы связи и полезная информация",
                    subBlocks = listOf(
                        SubBlock("Приветствие", "Приветственное слово к государственным и муниципальным служащим", "governor_speech", Color(0xFF7E57C2), "🗣️"),
                        SubBlock("Информационые каналы", "Официальные ресурсы и цифровые инструменты обратной связи", "mcu_screen", Color(0xFF00A652), "🔗"),
                        SubBlock("Информация о регионе", "Заготовка под историческую справку и достижения", "about_region", Color(0xFF1E88E5), "ℹ️")
                    )
                )
            }

            ExpandableBlockCard(
                mainBlock = welcomeBlock,
                navController = navController,
                isExpanded = viewModel.isWelcomeExpanded,
                onToggleExpand = {
                    viewModel.toggleWelcomeBlock()
                }
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Категории развития 🎯",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        items(catalogBlocks, key = { it.id }) { mainBlock ->
            val isExpanded = viewModel.expandedBlockId == mainBlock.id

            ExpandableBlockCard(
                mainBlock = mainBlock,
                navController = navController,
                isExpanded = isExpanded,
                onToggleExpand = {
                    viewModel.toggleBlock(mainBlock.id)
                }
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Материалы для работы 🤝",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            val adaptationBlock  = remember {
                MainBlock(
                    id = 3, // Уникальный ID блока
                    title = "Поддержка нового сотрудника",
                    subtitle = "Нормативные документы, правила языка, вопросы контроля и рекомендации",
                    subBlocks = listOf(
                        SubBlock("Нормативно-правовые документы", "Уставы, регламенты и базовые нормативные акты для ознакомления", "legal_documents", Color(0xFF7E57C2), "📜"),
                        SubBlock("Правила русского языка", "Шпаргалка по деловой переписке, грамотности и оформлению писем", "russian_language_rules", Color(0xFF00A652), "✍️"),
                        SubBlock("Вопросы контроля", "Правила исполнительской дисциплины, работа со сроками и регламент ответов", "control_questions", Color(0xFF1E88E5), "🔍"),
                        SubBlock("Рекомендации к прочтению", "Список книг, лекций и полезных ресурсов, рекомендованных к прочтению", "governor_recommendations", Color(0xFFF57C00), "📚")
                    )
                )
            }

            ExpandableBlockCard(
                mainBlock = adaptationBlock,
                navController = navController,
                isExpanded = viewModel.isAdaptationExpanded,
                onToggleExpand = {
                    viewModel.toggleAdaptationBlock()
                }
            )
        }
    }
}

private fun getCatalogStructure(): List<MainBlock> {
    return listOf(
        MainBlock(
            id = 1,
            title = "Теоретические основы",
            subtitle = "Нормативные акты, ценности и кодексы поведения госслужащего",
            subBlocks = listOf(
                SubBlock("Главное из Стратегии развития Калужской области 2030", "Вектор развития региона и главные стратегические цели", "strategy_2030", Color(0xFF00A652), "🚀"),
                SubBlock("Ценности государственного и муниципального служащего", "Фундаментальные ориентиры и принципы ежедневной работы", "values_screen", Color(0xFFF2C12E), "💎"),
                SubBlock("Кодекс этики", "Стандарты профессионального поведения и корпоративная культура", "ethics_code", Color(0xFFE40102), "📜"),
                SubBlock("Правила поведения в социальных сетях", "Цифровой этикет и нормы ведения личных аккаунтов", "social_rules", Color(0xFF7E57C2), "🤝")
            )
        ),
        MainBlock(
            id = 2,
            title = "Полезные инструменты",
            subtitle = "Практические техники, навыки soft-skills и цифровые ассистенты",
            subBlocks = listOf(
                SubBlock("Планирование", "Матрица Эйзенхауэра, визуальный таск-трекер, правило «1-3-5»", "planning_matrix", Color(0xFF1E88E5), "📅"),
                SubBlock("Коммуникация", "Эффективное общение, активное слушание и метод гамбургера", "communication", Color(0xFFF57C00), "🗣️"),
                SubBlock("Командная работа", "Карта внутренней кухни, поиск экспертов и адаптация в коллективе", "teamwork", Color(0xFF8E24AA), "👥"),
                SubBlock("Ресурсы стрессоустойчивости", "Снятие стресса в моменте и долгосрочная профилактика", "stress_management", Color(0xFF00A652), "🧘"),
                SubBlock("Нейросети", "Обзор основных ИИ-инструментов для автоматизации рутины", "ai_tools", Color(0xFF26A69A), "🤖")
            )
        )
    )
}
