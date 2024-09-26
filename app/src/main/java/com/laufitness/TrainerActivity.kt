package com.laufitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laufitness.ui.theme.LauFitnessTheme

class TrainerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LauFitnessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrainerScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TrainerScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Nuestros Entrenadores",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Aquí puedes agregar más entrenadores
        TrainerItem(
            image = R.drawable.trainer1, // Cambia con tus imágenes
            name = "Juan Pérez",
            specialty = "Entrenador Personal",
            description = "Juan tiene más de 5 años de experiencia ayudando a sus clientes a alcanzar sus metas de fitness."
        )
        Spacer(modifier = Modifier.height(16.dp))
        TrainerItem(
            image = R.drawable.trainer1, // Cambia con tus imágenes
            name = "María Gómez",
            specialty = "Nutricionista",
            description = "María te ayudará a crear un plan de alimentación adaptado a tus necesidades."
        )
        Spacer(modifier = Modifier.height(16.dp))
        TrainerItem(
            image = R.drawable.trainer1, // Cambia con tus imágenes
            name = "Carlos Ruiz",
            specialty = "Instructora de Yoga",
            description = "Carlos enseña técnicas de respiración y relajación para el bienestar integral."
        )
    }
}

@Composable
fun TrainerItem(image: Int, name: String, specialty: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Imagen de $name",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )

        Text(
            text = specialty,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
