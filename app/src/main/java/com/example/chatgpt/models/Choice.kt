package com.example.chatgpt.models

data class Choice(
    val finish_reason: String,
    val index: Int,
    val message: Message
)