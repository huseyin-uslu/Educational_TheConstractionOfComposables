package com.firstprojects.composeactivity.otherTutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HelloComposeActivityTutorial_1st : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.firstprojects.composeactivity.ui.theme.ComposeActivityTheme {
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
    Surface(color = Color.Black){
        //Row , Column , Box

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {


            //github.com/huseyin-uslu

            var i = 0;
            val names = arrayListOf("World!","Android!","Compose!","Kotlin!","Hüseyin!")
            val colors = arrayListOf(Color.Cyan, Color.Green, Color.Magenta, Color.Blue, Color.Red)

            while (i < 5){
                editText(text = names[i], color = colors[i], fontSize = (50 - i * 5).sp )
                i++
            }

        }

    }
}

@Composable
private fun editText(text : String, color : Color, fontSize: TextUnit){
    Spacer(modifier = Modifier.padding(5.dp))
    Text(text = "Hello $text",
        modifier = Modifier.padding(20.dp),
        color = color ,
        fontSize = fontSize,
    )

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mainview()
}

//in this tutorial , I've made my first composable app. Basic , easy but it's teaching.