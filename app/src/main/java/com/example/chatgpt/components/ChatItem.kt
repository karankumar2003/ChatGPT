package com.example.chatgpt.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.chatgpt.models.ChatMessage
import com.example.chatgpt.util.Constants.CHATGPT
import com.example.chatgpt.util.Constants.YOU

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatItem(chatMessage: ChatMessage, modifier: Modifier = Modifier) {

    val alignment = if (chatMessage.sentBy == YOU) {
        Alignment.CenterEnd
    } else {
        Alignment.CenterStart
    }

    val color = if (chatMessage.sentBy == YOU) {
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.onBackground
    }

    val leftPadding = if(chatMessage.sentBy == YOU){
        100.dp
    }else{
        0.dp
    }
    val rightPadding = if(chatMessage.sentBy == YOU){
        0.dp
    }else{
        100.dp
    }

    Box(
        contentAlignment = alignment,
        modifier = modifier.fillMaxWidth()

    ) {

        Card(
            onClick = { /*TODO*/ },
            modifier = modifier
                .padding(start = leftPadding,end = rightPadding),
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
                text = chatMessage.message?:"", modifier = Modifier
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
    ChatItem(ChatMessage("Hello there! \uD83D\uDC4B How may I assist you today?", CHATGPT))
}