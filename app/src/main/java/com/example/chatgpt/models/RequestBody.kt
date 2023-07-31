package com.example.chatgpt.models

import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("model")
    val model: String,

    @SerializedName("messages")
    val messages: List<Message>
)