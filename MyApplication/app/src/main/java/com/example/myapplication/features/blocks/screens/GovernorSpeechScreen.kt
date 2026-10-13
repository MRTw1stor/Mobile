package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun GovernorSpeechScreen(navController: NavController) {
    CatalogBaseScreen(title = "Приветствие", navController = navController) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
            )
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.gubernator),
                    contentDescription = "В. В. Шапша",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Губернатор Калужской области\nВладислав Валерьевич Шапша",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp, horizontal = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(2.dp)
                    )
            )

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = "«Самое главное в работе госслужащего - необходимость обладать выдержкой, не бояться критики и много трудиться, уметь признавать ошибки и исправлять их, владеть „мягкими“ навыками и работать в команде».",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic // Курсив выделяет прямую речь
                ),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f), // Чуть мягче основного текста
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Калужская область — это не просто регион на карте России. Это регион-предприниматель, драйвер изменений и точка притяжения возможностей для всей центральной части страны.",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "Наша общая миссия — продолжать традицию лидерства, каждый день внедряя новые, эффективные инструменты для развития территории и повышения качества жизни людей. Это будет происходить через:",
            style = MaterialTheme.typography.bodyLarge
        )

        val missionPoints = listOf(
            "Обеспечение роста качества жизни населения на основе повышения конкурентоспособности региона и устойчивого экономического развития;",
            "Укрепление экономической самостоятельности, социальной стабильности и технологического лидерства;",
            "Определение путей и способов формирования новой экономической модели с учётом национальных стратегических целей, задач и планов."
        )

        missionPoints.forEach { pointText ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(4.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Text(
                        text = pointText,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "И перед нами стоит амбициозная, но абсолютно достижимая стратегическая цель: к 2040 году укрепить экономическую самостоятельность, социальную стабильность и технологическое лидерство Калужской области. Эта цель — наш общий маршрут. Каждое ваше решение, каждый проект, каждое взаимодействие с жителями — это вклад в её реализацию.",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
    }
}
