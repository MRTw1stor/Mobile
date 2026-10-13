package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign
import com.example.myapplication.R

@Composable
fun RegionStatistik() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = "Калужская область сегодня 🌐",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Субъект Российской Федерации, входит в состав Центрального федерального округа. Расположена в центре Европейской части России. Граничит с территорией города Москвы, Московской, Тульской, Брянской, Смоленской, Орловской областями.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gerb_kaluga_obl),
                        contentDescription = "Герб Калужской области",
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Герб Калужской области",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.flag_kaluga),
                        contentDescription = "Флаг Калужской области",
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Флаг Калужской области",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🎵 Гимн Калужской области",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Торжествуй и процветай,\n" +
                            "Славься жизнью новой,\n" +
                            "Древний наш Калужский край,\n" +
                            "Край наш родниковый.\n" +
                            "Серебром озер сверкай\n" +
                            "В предрассветной сини\n" +
                            "Наш родной Калужский край,\n" +
                            "Ты душа России!\n\n" +
                            "Припев:\n" +
                            "Сохраним навсегда небосвод голубой,\n" +
                            "Заповедную ширь, и леса, и поля,\n" +
                            "Ты навеки со мной, я навеки с тобой,\n" +
                            "Благословенная земля!\n\n" +
                            "Сберегай нас чистотой\n" +
                            "Веры непритворной,\n" +
                            "Богородицы святой\n" +
                            "Образ чудотворный!\n" +
                            "Край ученых и творцов,\n" +
                            "К звездам устремленных,\n" +
                            "Умножай труды отцов,\n" +
                            "В битвах закаленных!\n\n" +
                            "Припев:\n" +
                            "От начала веков и до нынешних дней,\n" +
                            "Мы едины судьбой со страною своей,\n" +
                            "Отчий дом — синь небес, и леса, и поля,\n" +
                            "Благословенная земля!",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        lineHeight = androidx.compose.ui.unit.TextUnit.Unspecified
                    ),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f))
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Ключевые показатели Калужской области \n(на 2025 год) 📈",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )

        val stats = listOf(
            "Площадь территории" to "29 777 км²",
            "Численность населения" to "1 066 601 чел.",
            "Дата образования области" to "5 июля 1944 года"
        )

        stats.forEach { (label, value) ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(label, fontWeight = FontWeight.Medium, style = MaterialTheme.typography.bodyMedium)
                    Text(value, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Административно-территориальное устройство 🗺️",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text("• 23 Муниципальных округа", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                Text("• 1 Муниципальный район", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                Text("• 2 Городских округа", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Областной центр: город Калуга",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}