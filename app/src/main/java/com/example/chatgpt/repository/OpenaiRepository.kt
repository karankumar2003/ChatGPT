package com.example.chatgpt.repository

import com.example.chatgpt.models.GptResponse
import com.example.chatgpt.models.RequestBody
import com.example.chatgpt.network.OpenaiApi
import javax.inject.Inject

class OpenaiRepository @Inject constructor(private val api : OpenaiApi) {

    suspend fun sendPrompt(prompt:RequestBody) : GptResponse =
        api.sendPrompt(prompt)
}