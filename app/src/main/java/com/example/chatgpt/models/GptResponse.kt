package com.example.chatgpt.models

data class GptResponse(
    val choices: List<Choice>,
    val created: Int,
    val id: String,
    val `object`: String,
    val usage: Usage
)