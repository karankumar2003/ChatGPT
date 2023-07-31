package com.example.chatgpt.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatgpt.components.ChatItem
import com.example.chatgpt.models.ChatMessage
import com.example.chatgpt.models.Message
import com.example.chatgpt.models.RequestBody
import com.example.chatgpt.util.Constants.YOU

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "ChatGPT")
                }
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {


            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                items(homeScreenViewModel.messageList) {
                    ChatItem(chatMessage = it)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            var prompt by remember {
                mutableStateOf("")
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                OutlinedTextField(
                    value = prompt,
                    onValueChange = {
                        prompt = it
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    maxLines = 10,
                    placeholder = {
                        Text(text = "Message")
                    }, shape = RoundedCornerShape(40.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    )
                )

                IconButton(
                    onClick = {
                        val message = ChatMessage(prompt, YOU)
                        homeScreenViewModel.addMessage(message)
                        Log.d("HomeScreenViewModel", "HomeScreen: ${homeScreenViewModel.messageList.size}")

                        val requestBody = RequestBody("gpt-3.5-turbo", listOf(Message("user",prompt)))
                        homeScreenViewModel.sendPrompt(requestBody)
                        prompt = ""
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.Bottom)
                        .padding(bottom = 4.dp, end = 8.dp)
                        .background(
                            color = if (prompt == "") MaterialTheme.colorScheme.onBackground.copy(
                                alpha = 0.4f
                            ) else MaterialTheme.colorScheme.primary, shape = CircleShape
                        )
                ) {
                    Icon(
                        Icons.Default.Send,
                        contentDescription = "Send",
                        tint = if (prompt == "") MaterialTheme.colorScheme.onSecondaryContainer.copy(
                            alpha = 0.4f
                        ) else MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

        }
    }
}