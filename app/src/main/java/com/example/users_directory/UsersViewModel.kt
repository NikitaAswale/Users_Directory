package com.example.users_directory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository : UsersRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<Users>>(emptyList())

    val users : StateFlow<List<Users>> = _users

    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }
}