package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.features.blocks.screens.AiScreen
import com.example.myapplication.features.blocks.screens.CommunicationScreen
import com.example.myapplication.features.blocks.screens.EthicsCodeScreen
import com.example.myapplication.features.blocks.screens.PlanningScreen
import com.example.myapplication.features.blocks.screens.SocialRulesScreen
import com.example.myapplication.features.blocks.screens.Strategy2030Screen
import com.example.myapplication.features.blocks.screens.StressScreen
import com.example.myapplication.features.blocks.screens.ValuesScreen
import com.example.myapplication.features.dashboard.HomeScreen
import com.example.myapplication.features.settings.presentation.SettingsScreen
import com.example.myapplication.features.blocks.screens.GovernorSpeechScreen
import com.example.myapplication.features.blocks.screens.McuScreen
import com.example.myapplication.features.blocks.screens.AboutRegionScreen
import com.example.myapplication.features.blocks.screens.TeamworkScreen
import com.example.myapplication.features.blocks.screens.ControlQuestionsScreen
import com.example.myapplication.features.blocks.screens.LegalDocumentsScreen
import com.example.myapplication.features.blocks.screens.RussianLanguageScreen
import com.example.myapplication.features.blocks.screens.GovernorRecommendationsScreen

@Composable
fun AppNavigation(navController: NavHostController, startScreen: String) {
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {
        composable("home_screen") { HomeScreen(navController = navController) }
        composable("settings") { SettingsScreen(navController = navController) }

        composable("governor_speech") { GovernorSpeechScreen(navController = navController) }
        composable("mcu_screen") { McuScreen(navController = navController) }
        composable("about_region") { AboutRegionScreen(navController = navController) }

        composable("strategy_2030") { Strategy2030Screen(navController) }
        composable("ethics_code") { EthicsCodeScreen(navController) }
        composable("social_rules") { SocialRulesScreen(navController) }
        composable("planning_matrix") { PlanningScreen(navController) }
        composable("ai_tools") { AiScreen(navController) }
        composable("values_screen") { ValuesScreen(navController) }
        composable("communication") { CommunicationScreen(navController) }
        composable("stress_management") { StressScreen(navController) }
        composable("teamwork") { TeamworkScreen(navController) }

        composable("control_questions") { ControlQuestionsScreen(navController) }
        composable("legal_documents") { LegalDocumentsScreen(navController) }
        composable("russian_language_rules") { RussianLanguageScreen(navController = navController) }
        composable("governor_recommendations") { GovernorRecommendationsScreen(navController = navController) }
    }
}
