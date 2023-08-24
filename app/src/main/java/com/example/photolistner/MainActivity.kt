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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.photolistner.ui.theme.PhotoListnerTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoListnerTheme {
                LayoutPhotoListener()
            }
        }
    }
}


@Composable
fun LayoutPhotoListener(){
    val viewModel: MainViewModel = viewModel()

    val uiState by viewModel.uiState

    val imageResource = when(uiState.photo){
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
                text = uiState.title,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = uiState.info,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.onButton1Click() }) {
                Text(text = "Previous")
            }

            Button(onClick = { viewModel.onButton2Click() }) {
                Text(text = "Next")
            }
        }
    }
}
