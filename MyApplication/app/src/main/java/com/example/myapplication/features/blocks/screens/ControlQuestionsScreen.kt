package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalUriHandler
import com.example.myapplication.core.utils.AnalyticsManager
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen

@Composable
fun ControlQuestionsScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    CatalogBaseScreen(title = "Вопросы контроля", navController = navController) {
        ControlRuleCard(
            title = "1. Жесткая ответственность «первого» в списке",
            color = Color(0xFF7E57C2)
        ) {
                Text("Суть: если поручение дано нескольким органам власти, то ответственным за итоговый результат является руководитель, указанный первым или с пометкой «свод, ответственный». Именно он обобщает все ответы и готовит финальный документ.", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Критичный нюанс: соисполнители обязаны сдать свои части головному исполнителю в течение первой половины срока, отведенного на исполнение.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            }

        ControlRuleCard(
            title = "2. Важность сроков и правило «предшествующего дня»",
            color = Color(0xFF1E88E5)
        ) {
                Text("Суть: срок исполнения определяется строго по резолюции (в порядке приоритета: индивидуальный срок в резолюции > срок по РКК).", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Формулировки «до» и «к» трактуются буквально: если указано «до 5 числа», ответ должен быть готов не позднее 4 числа.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Критичный нюанс: если последний день срока выпадает на выходной, исполнять нужно в предшествующий рабочий день.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Без даты: когда в резолюции и документе нет конкретной даты исполнения, поручение подлежит исполнению в 25-дневный срок.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Факт исполнения: поручение должностного лица о подготовке проекта письма за его подписью считается исполненным и снимается с контроля со дня передачи проекта письма, на подпись должностному лицу, подписавшему поручение.", style = MaterialTheme.typography.bodyMedium)
            }

        ControlRuleCard(
            title = "3. Правила для продления и отказа от поручения",
            color = Color(0xFFF2C12E)
        ) {
                Text("Для продления: Если срок срывается, нужно не просто просить больше времени, а подавать просьбу с обязательными пунктами: что уже сделано (и за какое время), почему не успели, и информацию о планируемой работе по поручению (план-график, если продление более чем на месяц).", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Для отказа: Если исполнитель считает, что задача не входит в область его компетенций, он обязан предложить привлечь других исполнителей или заменить исполнителя в течение 1/5 срока. Если он не успел это сделать - автоматически принимает ответственность на себя.", style = MaterialTheme.typography.bodyMedium)
            }

        ControlRuleCard(
            title = "4. Кто ставит подпись (неправильная подпись = неисполненное поручение)",
            color = Color(0xFFE40102)
        ) {
                Text("Суть: тип резолюции жестко определяет, чья подпись должна стоять:", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Резолюция «прошу подготовить» / «подготовить проект» - ответ идет за подписью руководителя, давшего поручение (или Губернатора, если указано).", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Резолюция «направить ответ / проинформировать» - ответ идет за подписью руководителя органа-исполнителя.", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Особый случай: если ответственным назначен заместитель Губернатора, информация Губернатору направляется исключительно за подписью этого заместителя.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold)
            }

        ControlRuleCard(
            title = "5. Содержание ответа и право вето контролера",
            color = Color(0xFF00A652)
        ) {
                Text("Суть: ответы на запросы должны сдержать информацию по каждому заданному вопросу:", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Если информацию требуется представить по форме, то информация предоставляется строго по форме, оставления пустых граф в таблицах не допускается.", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Если информацию предоставляется по нескольким пунктам протокола или перечня поручений, то в ответе информация должна быть отображена в разбивке по каждому пункту.", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Критично: если информация подается для участия Губернатора в мероприятии - каждый пункт списка формируется отдельным файлом. Отсутствие данных по пункту обязательно обосновывается в сопроводительном письме.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Последствие: начальник контрольного управления имеет право вернуть ответ на доработку, если ответ не соответствует этим требованиям.", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.error)
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
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Ознакомьтесь с полным текстом регламента исполнительской дисциплины. Данные всегда дополняются по мере изменения нормативных актов.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                Button(
                    onClick = {
                        AnalyticsManager.trackLinkClick(
                            linkName = "Перейти к полному документу вопросы контроля",
                            url = "https://disk.yandex.ru/i/3Dhci9Hta-nzlQ"
                        )
                        uriHandler.openUri("https://disk.yandex.ru/i/3Dhci9Hta-nzlQ")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Открыть полный документ",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun ControlRuleCard(
    title: String,
    color: Color,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth().padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f))
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            Box(modifier = Modifier.fillMaxHeight().width(4.dp).background(color))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = color)
                Spacer(modifier = Modifier.height(10.dp))
                Column(verticalArrangement = Arrangement.spacedBy(6.dp), content = content)
            }
        }
    }
}