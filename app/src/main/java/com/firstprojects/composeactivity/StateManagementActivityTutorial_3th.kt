package com.firstprojects.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.firstprojects.composeactivity.ui.theme.ComposeActivityTheme
import com.firstprojects.composeactivity.ui.theme.properRed


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Mainview()
                }
            }
        }
    }
}


@Composable
fun Mainview() {

    var myString by remember { mutableStateOf("Type something") }
    Surface(color = Color.Red){
        Column(Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            MyTextField(string = myString ){
                myString = it
            }
        }
    }
}

//github/huseyin-uslu
@Composable
fun MyTextField(string : String, onValueChanged : (String) -> Unit ){
    TextField(value = string, onValueChange = onValueChanged,modifier = Modifier.background(
        properRed),textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        Mainview()
}

//in this tutorial , I've learned how to use a stateful composable efficiently.