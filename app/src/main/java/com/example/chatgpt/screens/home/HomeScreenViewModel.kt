package com.example.chatgpt.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatgpt.models.ChatMessage
import com.example.chatgpt.models.RequestBody
import com.example.chatgpt.repository.OpenaiRepository
import com.example.chatgpt.util.Constants.CHATGPT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: OpenaiRepository) :
    ViewModel() {

    private val _messageList = mutableStateListOf<ChatMessage>(
        ChatMessage("Hello there! \uD83D\uDC4B How may I assist you today?",CHATGPT)
    )

    val messageList = _messageList


    fun addMessage(message: ChatMessage) {
        _messageList.add(message)
    }

    fun sendPrompt(prompt: RequestBody) =
        viewModelScope.launch {
            try {
                val response = repository.sendPrompt(prompt)
                val newMessage = ChatMessage(response.choices[0].message.content, CHATGPT)
                _messageList += newMessage
            } catch (e: Exception) {
                Log.d("HomeScreenViewModel", "sendPrompt: ${e.message}")
            }

        }

}