package com.example.projekt_androidutveckling

import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    var value: Int = 0

    fun add() {
        value++
    }

}