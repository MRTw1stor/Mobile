package com.example.myapplication.features.blocks.info

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import com.example.myapplication.features.blocks.model.InfoCard
import com.example.myapplication.R

@Composable
fun RegionPeople() {
    val people = remember {
        listOf(
            Triple(
                "Георгий Константинович Жуков",
                "Маршал Советского Союза, четырежды Герой Советского Союза. Родился в деревне Стрелковка Малоярославецкого уезда Калужской губернии. Выдающийся полководец Второй мировой войны.",
                R.drawable.people_zhukov
            ),
            Triple(
                "Константин Георгиевич Паустовский",
                "Знаменитый советский писатель, мастер отечественной прозы, сценарист и педагог. Жил и активно творил на калужской земле, воспевая красоту её природы.",
                R.drawable.people_paustovskyi
            ),
            Triple(
                "Марина Ивановна Цветаева",
                "Известная русская поэтесса Серебряного века, прозаик и переводчик. Её жизнь и творческие периоды были тесно связаны с вдохновляющими калужскими местами.",
                R.drawable.people_tsvetaeva
            ),
            Triple(
                "Константин Эдуардович Циолковский",
                "Знаменитый русский и советский учёный-самоучка, разрабатывавший теоретические вопросы космонавтики, мыслитель эзотерической ориентации, занимавшийся философскими проблемами освоения космоса.",
                R.drawable.people_tsialkovskyi
            ),
            Triple(
                "Николай Васильевич Гоголь",
                "Известный русский писатель, классик золотого века русской литературы. Подолгу жил и работал в Калуге у своей фрейлины А. О. Смирновой-Россет, а также неоднократно посещал Оптину пустынь. Именно в Калуге он сжег один из вариантов второго тома «Мертвых душ».",
                R.drawable.people_gogol
            ),
            Triple(
                "Василий Дмитриевич Поленов",
                "Великий русский пейзажист, подолгу жил и писал свои знаменитые полотна на берегах Оки в районе Тарусы.",
                R.drawable.people_polenov
            ),
            Triple(
                "Александр Леонидович Чижевский",
                "Выдающийся биофизик, основоположник гелиобиологии и космической погоды, который в Калуге провел свои ключевые исследования и изобрел знаменитую «люстру Чижевского».",
                R.drawable.people_chizhevskyi
            )
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Великие имена Калужской земли 🏛️",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        people.forEach { (name, bio, imageRes) ->
            InfoCard(
                title = name,
                description = bio,
                accentColor = MaterialTheme.colorScheme.primary
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}