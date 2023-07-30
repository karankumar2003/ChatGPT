package com.example.chatgpt.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatgpt.models.ChatMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatItem(chatMessage: ChatMessage, modifier: Modifier = Modifier) {

    val alignment = if (chatMessage.sentBy == "You") {
        Alignment.CenterEnd
    } else {
        Alignment.CenterStart
    }

    val color = if (chatMessage.sentBy == "You") {
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.onBackground
    }

    Box(
        contentAlignment = alignment,
        modifier = modifier.fillMaxWidth()
    ) {

        Card(
            onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth(0.8f),
            colors= CardDefaults.cardColors(containerColor = color)
        ) {
            Text(
                text = chatMessage.sentBy,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                text = chatMessage.message, modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer

            )
        }
    }
}

@Preview
@Composable
fun ChatItemPrev() {
    ChatItem(ChatMessage("Hello, This is a ChatGPT android app!", "CHATGPT"))
}