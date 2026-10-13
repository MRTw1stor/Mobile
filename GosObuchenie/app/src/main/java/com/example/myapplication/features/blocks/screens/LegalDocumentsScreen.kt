package com.example.myapplication.features.blocks.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.core.utils.AnalyticsManager
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen


@Composable
fun LegalDocumentsScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    CatalogBaseScreen(title = "Нормативные документы", navController = navController) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.08f)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Коллега, ваш первый месяц на государственной и муниципальной службе — самый важный: он определит, пройдете ли вы испытательный срок и как быстро вольетесь в коллектив. В отличие от коммерческого сектора, на госслужбе первичны законность, регламенты и государственная этика.",
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 20.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.15f)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(5.dp)
                        .background(
                            color = MaterialTheme.colorScheme.error,
                            shape = RoundedCornerShape(topStart = 2.dp, bottomStart = 2.dp)
                        )
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "⚠️", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ВАЖНОЕ ПРАВИЛО ДИСЦИПЛИНЫ",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Помните, что незнание действующих нормативных актов и внутренних регламентов не освобождает от персональной ответственности за срыв установленных сроков или неверное юридическое оформление исполнительной документации.",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontStyle = FontStyle.Italic,
                            lineHeight = 20.sp
                        ),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }
        Text(
            text = "Ваша библиотека делится на три ключевых блока:",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        DocumentBlock(
            title = "Блок 1. Обязательная база (законы)",
            subtitle = "Без понимания этих документов невозможно принимать легитимные решения. Читать их нужно не как художественную литературу, а с карандашом.",
            icon = Icons.Default.MenuBook
        ) {
            DocumentItem(
                number = "1",
                title = "Федеральный закон № 79-ФЗ «О государственной гражданской службе РФ»",
                desc = "Ваша главная настольная книга. Особое внимание уделите статьям о конфликте интересов, ограничениях, запретах, классных чинах, аттестации и увольнении.\n📌 Держите под рукой также региональный закон Калужской области #196-ОЗ."
            )
            DocumentItem(
                number = "2",
                title = "Федеральный закон № 59-ФЗ «О порядке рассмотрения обращений граждан»",
                desc = "Вы будете работать с письмами и жалобами. Ошибка в сроках или процедуре ответа — частое основание для прокурорских проверок и взысканий."
            )
            DocumentItem(
                number = "3",
                title = "Федеральный закон № 273-ФЗ «О противодействии коррупции»",
                desc = "Изучите понятия конфликта интересов. Сразу заведите привычку при любой спорной ситуации советоваться с подразделением по профилактике коррупционных нарушений."
            )
            DocumentItem(
                number = "4",
                title = "Постановление Губернатора Калужской области № 535",
                desc = "«О системе и структуре исполнительных органов Калужской области» от 23.09.2025."
            )
            DocumentItem(
                number = "5",
                title = "Устав Калужской области",
                desc = "Фундаментальный документ регионального законодательства."
            )
        }

        DocumentBlock(
            title = "Блок 2. Управленческая культура и контроль",
            subtitle = "На госслужбе бумага имеет большое значение. Умение писать официальные документы ценится так же высоко, как и умение красиво говорить.",
            icon = Icons.Default.Assignment
        ) {
            Text(
                text = "Запомните правила нумерации, визирования, оформления реквизитов. В каждом ведомстве есть своя инструкция, но базируется она на ГОСТе и Постановлениях:",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            DocumentItem(
                number = "1",
                title = "ГОСТ Р 7.0.97-2016",
                desc = "Правила оформления организационно-распорядительной документации."
            )
            DocumentItem(
                number = "1",
                title = "Постановление Правительства КО № 400 от 09.08.2012",
                desc = "«Об утверждении Положения о правилах делопроизводства в исполнительных органах государственной власти Калужской области»."
            )
            DocumentItem(
                number = "1",
                title = "Постановление Губернатора КО № 555 от 14.11.2012",
                desc = "«О мерах по совершенствованию организации контроля за исполнением поручений Губернатора и Правительства Калужской области»."
            )
        }

        DocumentBlock(
            title = "Блок 3. Смысл и контекст (отрасль)",
            subtitle = "Чтобы быть эффективным, нужно понимать, частью какого большого процесса вы являетесь.",
            icon = Icons.Default.TrendingUp
        ) {
            DocumentItem(
                number = "1",
                title = "Указы Президента РФ о национальных целях развития",
                desc = "Цели до 2030 года и на перспективу до 2036 года. Любая программа работает на их достижение. Поймете верхнеуровневые показатели (KPI государства) — будет проще готовить отчеты."
            )
            DocumentItem(
                number = "2",
                title = "Концепция «Государство для людей»",
                desc = "Принципы клиентоцентричности. Поймите, кто является «клиентом» вашей государственной услуги или функции."
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Официальный источник 📄",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "База документов регулярно дополняется и обновляется в реальном времени.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                Button(
                    onClick = {
                        AnalyticsManager.trackLinkClick(
                            linkName = "Перейти к нормативно-правовым документам",
                            url = "https://yandex.ru"
                        )
                        uriHandler.openUri("https://yandex.ru")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Открыть документы", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DocumentBlock(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    content()
                }
            }
        }
    }
}

@Composable
fun DocumentItem(
    number: String,
    title: String,
    desc: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = "$number.",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.width(28.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 18.sp
            )
        }
    }
}
