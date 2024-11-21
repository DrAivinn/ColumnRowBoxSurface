package com.example.columnrowboxsurface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val persons = listOf(
            Person("Алексей", "150000"),
            Person("Михаил", "30000"),
            Person("Марина", "55000"),
            Person("Николай", "45000"),
            Person("Алёна", "33000"),
            Person("Олег", "75000"),
            Person("Александр", "65000"),
            Person("Мария", "85000"),
            Person("Петр", "44000"),
        )
        setContent {
            Column {
                Text(
                    "Данные по персоналу",
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 8.dp, start = 8.dp, end = 8.dp
                        )
                        .background(Color.DarkGray),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .background(Color.Gray), Arrangement.SpaceEvenly
                ) {
                    Text("Имя", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Зарплата", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Телефон", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                PersonInfo(persons)
            }
        }
    }

    @Composable
    fun PersonInfo(persons: List<Person>) {
        for (person in persons) {
            randomPhoneNumber(person)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .border(border = BorderStroke(1.dp, Color.Black))
                    .padding(horizontal = 8.dp), Arrangement.SpaceBetween
            ) {
                Text(person.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(person.salary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(person.phone, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

    private fun randomPhoneNumber(person: Person) {
        val number = "+7${Random.nextLong(9000000000, 9999999999)}"
        person.phone = number
    }
}
