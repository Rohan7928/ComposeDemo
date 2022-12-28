package com.example.composedemo.ui.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class LoginModel(
    val pref: Pref
) : ViewModel() {
    var courseList = MutableLiveData<String>()
    fun saveUserName(name: String) {
        viewModelScope.launch {
            pref.saveUserName(name)
        }
    }

    @Composable
    fun getUser() : State<String>
    {
        val state = pref.getUserName.collectAsState(initial = "")
        var courseList: State<String> = state
        return courseList
    }






}