package com.example.chatgpt.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatItem(text: String) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 80.dp)
    ) {
        Text(text = text,modifier = Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun ChatItemPrev() {
    ChatItem(text = "Hello, This is a ChatGPT android app")
}