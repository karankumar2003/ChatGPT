package com.example.chatgpt.network

import com.example.chatgpt.models.GptResponse
import com.example.chatgpt.models.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenaiApi {

    @POST("/v1/chat/completions")
    suspend fun sendPrompt(@Body body: RequestBody) : GptResponse
}