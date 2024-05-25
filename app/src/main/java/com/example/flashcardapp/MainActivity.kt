package com.example.flashcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flashcardapp.ui.theme.FlashCardAppTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf

data class Deck(val name: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Button(onClick = { /* Create new deck */ }) {
                            Text("Create Deck")
                        }
                        Button(onClick = { /* Create new card */ }) {
                            Text("Create Card")
                        }
                        LazyColumn {
                            // Items for the list of decks
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FlashcardApp() {
    val decks = remember {
        mutableStateListOf<Deck>() }

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Button(onClick = {
            /* Create new deck */ }) {
                Text("Create Deck")
            }
            LazyColumn {
                items(decks) { deck ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(deck.name, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlashCardAppTheme {
        FlashcardApp()
    }
}