package com.example.divpro.features.characters.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.divpro.features.characters.domain.CharacterInteractor
import com.example.divpro.features.characters.domain.model.Character
import com.example.divpro.utils.ViewState
import com.example.divpro.utils.asLiveData
import com.example.divpro.utils.asViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterInteractor: CharacterInteractor
): ViewModel(){

    private val _character = MutableLiveData<ViewState<Character>>()
    val character get() = _character.asLiveData()

    private val _isVisible = MutableLiveData(true)
    val isVisible get() = _isVisible.asLiveData()

    init {
        getCharacter()
    }

    private fun getCharacter(){
        _isVisible.value = true
        viewModelScope.launch {
            _character.value = characterInteractor.getCharacter().asViewState()
            _isVisible.value = false
        }
    }
}
