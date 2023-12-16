package com.d121211086.Minuman


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211086.Minuman.data.models.Minum
import com.d121211086.Minuman.data.repository.DrinkRepository
import com.d121211086.Minuman.main.MyApplication
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val minuman: List<Minum>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val minumanRepo: DrinkRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getDrink() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = minumanRepo.getDrinks(
                "Non_Alcoholic"
                            )
            mainUiState = MainUiState.Success(result.drinks.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getDrink()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val minumanRepository = application.container.drinkRepository
                MainViewModel(minumanRepository)
            }
        }
    }
}