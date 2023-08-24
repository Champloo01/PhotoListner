package com.example.photolistner

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var uiState = mutableStateOf<UiState>(UiState())

    private var photo by mutableStateOf(1)

    private var title: String = ""
    private var info: String = ""

    init {
        changeData()
    }

    private fun changeData() {
        when (photo) {
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
        }

        uiState.value = uiState.value.copy(photo = photo, title = title, info = info)
    }

    fun onButton1Click() {
        photo++

        changeData()
    }

    fun onButton2Click() {
        photo--

        changeData()
    }
}