package com.example.projekt_androidutveckling

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelUser {
    private val _UIState = MutableStateFlow(UserUIState())
    val UIState: StateFlow<UserUIState> = _UIState.asStateFlow()

    fun inloggedUser(username : String) {
        _UIState.update {
            state -> state.copy(
            userName = username
            )
        }
    }

}