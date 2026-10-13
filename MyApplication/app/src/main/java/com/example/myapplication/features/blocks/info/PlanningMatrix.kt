package com.example.myapplication.features.blocks.info

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import com.example.myapplication.core.utils.AnalyticsManager

@Composable
fun EisenhowerMatrix() {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Матрица Эйзенхауэра — простая таблица, разделяющая дела по важности и срочности. Она позволяет приоритизировать задачи, помогает планировать рабочее и свободное время. Техника помогает быстро рассортировать дела из списка, даже если их много. Достаточно сформировать список задач и ответить на два вопроса о каждой из них:\n1) Это важно? Да/Нет\n2) Это срочно? Да/Нет",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Сетка приоритетов матрицы:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Card(
                    modifier = Modifier.weight(1f).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF00838F).copy(alpha = 0.15f))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "A",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00838F)
                        )
                        Text(
                            "СРОЧНО\nВАЖНО",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF00838F)
                        )
                    }
                }
                Card(
                    modifier = Modifier.weight(1f).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF00A652).copy(alpha = 0.15f))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "B",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00A652)
                        )
                        Text(
                            "НЕ СРОЧНО\nВАЖНО",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF00A652)
                        )
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Card(
                    modifier = Modifier.weight(1f).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE40102).copy(alpha = 0.11f))
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "C",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE40102)
                        )
                        Text(
                            "СРОЧНО\nНЕ ВАЖНО",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color(0xFFE40102)
                        )
                    }
                }
                Card(
                    modifier = Modifier.weight(1f).padding(4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "D",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            "НЕ СРОЧНО\nНЕ ВАЖНО",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Структура ячеек матрицы:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        val matrixDetails = listOf(
            Triple(
                "A. Ячейка важных и срочных дел",
                Color(0xFF00838F),
                "• Дела, невыполнение которых ставит под угрозу достижение цели;\n• Задачи, которые необходимо решить, чтобы избежать больших затруднений в жизни;\n• Вопросы здоровья.\n\nПримеры: Отвезти родственника в больницу, подготовить отчёт для экстренного совещания — к этой ячейке относятся внезапные дела, откладывать которые нельзя, и задачи, которые возникли из-за кризисов или форс-мажоров."
            ),
            Triple(
                "B. Ячейка важных, но не срочных дел",
                Color(0xFF00A652),
                "• Основная деятельность на работе;\n• Повседневные дела, которые нельзя не делать.\n\nЗдесь находятся задачи, которым нужно уделять максимум внимания. Тот, кто хорошо работает с этой ячейкой, может рассчитывать на то, что добьётся своих целей. Эти задачи не горят, а значит, не делаются в состоянии паники. Главное — не затягивать, иначе они перейдут в ячейку А."
            ),
            Triple(
                "C. Ячейка срочных, но не важных дел",
                Color(0xFFE40102),
                "• Отвлекающие факторы.\n\nВыполнение этих задач не помогает достичь цели, они мешают сосредоточиться на действительно важном и снижают эффективность. Эта ячейка самая коварная — есть риск спутать дела из этого сектора с делами ячейки А и получить хаос в приоритетах (например, помощь коллеге в ущерб собственной работе)."
            ),
            Triple(
                "D. Ячейка несрочных и неважных дел",
                MaterialTheme.colorScheme.outline,
                "• Не несущие никакой пользы;\n• Наши любимые вещи.\n\nПарадоксальный квадрат: дела тут не приносят пользы, но часто приятны и участие мозга практически не требуется (социальные сети, разговоры по телефону и в мессенджерах, сёрфинг в Сети, компьютерные игры). Отдыхать от работы надо, но не в ущерб тому, что продвигает к целям."
            )
        )

        matrixDetails.forEach { (title, accentColor, desc) ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                    Box(modifier = Modifier.fillMaxHeight().width(4.dp).background(accentColor))
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = title, fontWeight = FontWeight.Bold, color = accentColor)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = desc, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                AnalyticsManager.trackLinkClick(
                    linkName = "Скачать шаблон Матрицы Эйзенхауэра",
                    url = "https://disk.yandex.ru/i/G9Mb-oayvQD14Q"
                )
                uriHandler.openUri("https://disk.yandex.ru/i/G9Mb-oayvQD14Q")
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "📥 Скачать образец матрицы",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}