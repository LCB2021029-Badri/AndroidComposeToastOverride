package com.example.testcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ToastButtonApp()
            }
        }
    }
}

@Composable
fun ToastButtonApp() {
    var currentToast: Toast? by remember { mutableStateOf(null) }
    var count by remember { mutableStateOf(1) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // Cancel previous toast if it exists
                currentToast?.cancel()

                // Create and show a new toast with the incremented count
                currentToast = Toast.makeText(context, "Hello $count", Toast.LENGTH_SHORT)
                currentToast?.show()

                // Increment the count after showing the toast
                count++
            }
        ) {
            Text("Show Toast")
        }
    }
}