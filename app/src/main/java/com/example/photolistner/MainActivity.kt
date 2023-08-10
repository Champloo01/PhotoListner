package com.example.photolistner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photolistner.ui.theme.PhotoListnerTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoListnerTheme {
                LayoutPhotoListner()
            }
        }
    }
}


@Composable
fun LayoutPhotoListner(){

    var photo by remember { mutableStateOf(1) }
    val title: String
    val info: String
    if (photo == 0){photo = 6}
    else if(photo == 7){photo = 1}

    val imageResource = when(photo){
        0 -> R.drawable.houseindvorische
        1 -> R.drawable.lidacastle
        2 -> R.drawable.lidabeer
        3 -> R.drawable.franc
        4 -> R.drawable.kinggedemin
        5 -> R.drawable.mail
        6 -> R.drawable.houseindvorische
        7 -> R.drawable.lidacastle
        else -> exitProcess(1)
    }

    when(photo){
        0 -> {
            title = "Усадьба в Дворище"
            info = "Lida 2023"
        }
        1 -> {
            title = "Лидский Замок"
            info = "Lida 2023"
        }
        2 -> {
            title = "Лидское Пиво"
            info = "Lida 2023"
        }
        3 -> {
            title = "Франциск Скорина"
            info = "Lida 2023"
        }
        4 -> {
            title = "Князь Гедемин"
            info = "Lida 2023"
        }
        5 -> {
            title = "Почта в Лиде"
            info = "Lida 2023"
        }
        6 -> {
            title = "Усадьба в Дворище"
            info = "Lida 2023"
        }
        7 -> {
            title = "Лидский Замок"
            info = "Lida 2023"
        }
        else -> exitProcess(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .height(260.dp)
                .size(380.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(0.7f)
        ) {
            Text(
                text = title,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = info,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))
        
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {--photo}) {
                Text(text = "Previous")
            }

            Button(onClick = {++photo}) {
                Text(text = "Next")
            }
        }
    }
}
