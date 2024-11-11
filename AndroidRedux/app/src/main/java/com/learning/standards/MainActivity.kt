package com.learning.standards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.standards.ui.theme.AppTheme
import com.learning.standards.ui.theme.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainAppView()
                }
            }
        }
    }
}

/// MARK: Main Screen
@Composable
fun MainAppView() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Kotlin Redux",
                fontSize = 30.sp
            )
            ActionView()
            Divider()
            CounterView()
        }
}

/// MARK: Helper Views
@Composable
fun ActionView() {
    Column(modifier = Modifier
        .padding(24.dp)) {
        Text(modifier = Modifier.padding(24.dp),
            text = "Actions")
        Row() {
            Button(onClick = { AppRedux.getInstance().store.dispatch(AppAction.Increment) }) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.weight(1.0f))
            Button(onClick = { AppRedux.getInstance().store.dispatch(AppAction.Decrement) }) {
                Text("Decrement")
            }
        }
    }
}

@Composable
fun CounterView() {
    val currentState by AppRedux.getInstance().store.publisher.collectAsState()
    Column(modifier = Modifier
        .padding(24.dp)) {
        Text(
            text = "State"
        )
        TextBoxView(currentState.currentValue.toString())
    }
}

/// MARK: UI Styling
@Composable
fun TextBoxView(text: String) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.border(width = 2.dp, color = Green, shape = RoundedCornerShape(10.dp))
        ) {
            Text(
                text = text,
                color = Color.LightGray,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.W800,
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MainAppView()
    }
}
