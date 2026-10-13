package com.example.myapplication.features.blocks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.features.blocks.presentation.CatalogBaseScreen
import com.example.myapplication.core.utils.AnalyticsManager

@Composable
fun AiScreen(navController: NavController) {
    val uriHandler = LocalUriHandler.current

    CatalogBaseScreen(title = "Обзор нейросетей", navController = navController) {

        Text(
            text = "🤖 Передовые ИИ-инструменты и ассистенты",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Современные нейросети — это мощные цифровые ассистенты, способные взять на себя рутинную работу, ускорить поиск информации, автоматизировать создание документов и написание кода.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.12f)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(4.dp)
                        .background(MaterialTheme.colorScheme.error)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🛡️ Правила безопасности при использовании ИИ",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.error
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "1. Конфиденциальность: никогда не загружайте в публичные нейросети персональные данные — ни свои, ни чужие.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "2. Тайна информации: не вводите тексты документов под грифами «ДСП» (Для служебного пользования), «Секретно» или содержащие коммерческую тайну.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "3. Проверка фактов: ИИ склонен «галлюцинировать» — обязательно перепроверяйте все ссылки на законы, статьи, даты и статистические данные.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "4. Присутствие человеческого фактора: не отправляйте ответы гражданам напрямую из ИИ без ручной проверки и утверждения руководителем.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "5. Цифровой след: помните, что все введенные вами запросы сохраняются на серверах разработчиков ИИ и могут быть использованы для обучения моделей.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.12f)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "✍️ Структура идеального промта",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Чтобы нейросеть подготовила качественный проект документа, отчета или ответа на обращение, используйте пять ключевых элементов:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Column {
                            Text("1. Роль: укажите должность или экспертную позицию.", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Text("Пример: «Ты ведущий юрист департамента ЖКХ».", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Column {
                            Text("2. Контекст: опишите предысторию или нормативную базу.", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Text("Пример: «Поступила жалоба от гражданина на качество уборки снега, руководствуемся Постановлением Правительства №ХХХ».", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Column {
                            Text("3. Задача: четко сформулируйте действие.", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Text("Пример: «Подготовь проект официального ответа заявителю об устранении нарушений».", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Column {
                            Text("4. Формат: задайте структуру и стиль документа.", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Text("Пример: «Оформи в официально-деловом стиле, объемом до 1 страницы, с разбивкой на вводную, констатирующую и резолютивную части».", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Column {
                            Text("5. Ограничения: укажите жесткие рамки.", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                            Text("Пример: «Не используй канцеляризмы, пиши простым языком, не выдумывай номера статей, если не уверен».", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "Готовый шаблон промта: 📝",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "«Ты — опытный специалист пресс-службы министерства. К нам поступил запрос от СМИ о сроках открытия нового детского сада. Напиши текст пресс-релиза. Объём — до 200 слов. Стиль — строго информационный. Избегай размытых формулировок и фраз вроде \"в ближайшее время\"».",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.12f)
            )
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(4.dp)
                        .background(MaterialTheme.colorScheme.tertiary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "💡 Критическое мышление при использовании ИИ",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Здраво оценивать ответы ИИ поможет навык критического мышления. Это способность анализировать информацию, проверять факты и делать логические выводы, не принимая всё на веру. Простыми словами, критическое мышление — это ваш внутренний \"фильтр\", позволяющий вам принимать в жизни здравые решения.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f))
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Основы критического мышления при использовании ИИ:",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = "1. Нейросеть — это черновик, а не истина. Не принимайте ответ ИИ за окончательный. Используйте его как основу или шаблон, но всегда перепроверяйте и дорабатывайте.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "2. Проверяем все в официальных источниках. Любую цифру, дату, ссылку на закон или исследование сверяйте с официальными данными (Консультант+, Росстат, сайт ведомства).",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "3. Нейросеть не делает, а предлагает варианты. Не просите «сделай за меня». Спрашивайте: «Какие есть варианты решения?» — и выбирайте подходящий сами. ИИ — генератор идей, а не исполнитель.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "4. Вы — эксперт, нейросеть — ассистент. Вы знаете контекст, законы и нюансы своей работы. ИИ этого не знает. Окончательное решение и ответственность — за вами.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "5. Ошиблась нейросеть — ошиблись и вы. Ответственность за любой ответ, взятый у ИИ, лежит на вас.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Нейросети, которыми вы можете воспользоваться 🛠️",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "Ниже представлены популярные ИИ-ассистенты, адаптированные для работы со сложными текстами, аналитикой и генерацией идей на русском языке:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // --- КАРТОЧКА 1: ЯНДЕКС GPT ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier.fillMaxHeight().width(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "ЯндексGPT",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Разработка Яндекса, которая максимально глубоко адаптирована под русский язык, его правила, сленг и культурные отсылки. Эту модель не нужно долго настраивать, она отлично понимает простые человеческие запросы. Сильнее всего её потенциал раскрывается внутри экосистемы компании. Например, она работает в связке с голосовым помощником Алисой, помогает быстро сокращать длинные статьи в браузере, выделяя главное, и генерирует черновики писем в Почте. Если вам нужно быстро набросать пост для соцсетей, переписать текст другими словами или придумать идеи для подарка, она сделает это быстро и на естественном русском языке.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            AnalyticsManager.trackLinkClick(
                                linkName = "Перейти в ЯндексGPT",
                                url = "https://alice.yandex.ru/"
                            )
                            uriHandler.openUri("https://alice.yandex.ru/")
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Перейти в ЯндексGPT")
                    }
                }
            }
        }

        // --- КАРТОЧКА 2: GIGACHAT ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier.fillMaxHeight().width(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "GigaChat от Сбера",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Создавался как универсальный виртуальный собеседник для российских пользователей и бизнеса. Его главное отличие от просто текстовых моделей — мультимодальность. Это значит, что внутри одного диалогового окна вы можете не только писать тексты или задавать вопросы, но и просить нейросеть нарисовать картинку, так как в неё встроена графическая модель Kandinsky. GigaChat хорошо держит контекст длинного разговора, умеет шутить, писать простые сценарии и даже базовый программный код. Из-за своей интеграции с сервисами Сбера он популярен в коммерции для автоматизации поддержки и создания шаблонов документов.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            AnalyticsManager.trackLinkClick(
                                linkName = "Перейти в GIGACHAT",
                                url = "https://giga.chat"
                            )
                            uriHandler.openUri("https://giga.chat")
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Перейти в GigaChat")
                    }
                }
            }
        }

        // --- КАРТОЧКА 3: QWEN ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier.fillMaxHeight().width(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Qwen (Alibaba)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Созданная китайским гигантом Alibaba, представляет собой мощное семейство моделей с открытым исходным кодом. В отличие от предыдущих нейросетей, Qwen создавалась с прицелом на международный рынок, поэтому она одинаково хорошо справляется со множеством языков, включая русский, английский и китайский. У неё очень большое «окно контекста», что позволяет загружать в неё огромные текстовые файлы, книги или длинные программные скрипты для анализа. Пользователи ценят Qwen за её техническую грамотность: она прекрасно программирует, находит баги в коде и переводит тексты с высокой точностью, сохраняя технические нюансы.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            AnalyticsManager.trackLinkClick(
                                linkName = "Перейти в QWEN",
                                url = "https://chat.qwen.ai/"
                            )
                            uriHandler.openUri("https://chat.qwen.ai/")
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Перейти в Qwen Chat")
                    }
                }
            }
        }

        // --- КАРТОЧКА 4: DEEPSEEK ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
                Box(
                    modifier = Modifier.fillMaxHeight().width(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "DeepSeek",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Это ещё один крупный технологический прорыв из Китая, который сильно пошатнул позиции мировых лидеров ИИ. Нейросеть создана с упором на сложную логику, математические вычисления и продвинутую разработку программного обеспечения. Её ключевая фишка — специальный режим рассуждения (серия моделей R1), когда перед выдачей ответа нейросеть строит внутреннюю цепочку мыслей, взвешивает варианты и проверяет сама себя на ошибки. Это делает её незаменимым инструментом для учёных, аналитиков и профессиональных программистов, которым нужно решать олимпиадные задачи или проектировать сложные архитектуры данных.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            AnalyticsManager.trackLinkClick(
                                linkName = "Перейти в DEEPSEEK",
                                url = "https://chat.deepseek.com/"
                            )
                            uriHandler.openUri("https://chat.deepseek.com/")
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Перейти в DeepSeek")
                    }
                }
            }
        }
    }
}
