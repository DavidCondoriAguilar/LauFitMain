package com.laufitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laufitness.ui.theme.LauFitnessTheme

class ComunidadActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LauFitnessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComunidadScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ComunidadScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Imagen Principal
        Image(
            painter = painterResource(id = R.drawable.yoga1), // Reemplaza con tu imagen
            contentDescription = "Comunidad",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        // Título y Pequeña Información
        Text(
            text = "Únete a Nuestra Comunidad",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Info, contentDescription = "Info")
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Conéctate con otros entusiastas del fitness y comparte tus experiencias.",
                fontSize = 16.sp
            )
        }

        // Textos Más Pequeños
        Text(
            text = "Más de 10,000 miembros activos.",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = "Eventos semanales y actividades grupales.",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 2.dp)
        )

        // Línea Separadora
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )

        // Sección de Foros
        Text(
            text = "Foros de Discusión",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Acordeón de Foros
        ForumItem(title = "¿Cómo mantener la motivación?", content = "Comparte tus mejores consejos y técnicas para mantener la motivación en el camino fitness.", date = "Fecha: 25 de septiembre de 2024")
        ForumItem(title = "Nutrición y Suplementación", content = "Discute sobre planes de nutrición y qué suplementos has encontrado útiles.", date = "Fecha: 26 de septiembre de 2024")
    }
}

@Composable
fun ForumItem(title: String, content: String, date: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.clickable { /* Lógica para abrir contenido del foro */ }
        )
        Text(
            text = content,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = date,
            fontSize = 12.sp,
            color = Color.Gray
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}
