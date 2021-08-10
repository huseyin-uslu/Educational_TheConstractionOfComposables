package com.firstprojects.composeactivity.otherTutorials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class SomeComposablesActivityTutorial_2nd : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.firstprojects.composeactivity.ui.theme.ComposeActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Mainview2()
                }
            }
        }
    }
}


@Composable
fun Mainview2() {
    Surface(color = Color.LightGray) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Hello",fontSize = 50.sp)
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            Button(onClick = { println("Clicked.")}) {
                Text("text")
                Text("button")
            }
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            Image(bitmap = ImageBitmap.imageResource(id = com.firstprojects.composeactivity.R.drawable.swordasset),contentDescription = null,
                Modifier.fillMaxWidth())
            Image(painter = rememberImagePainter("https://cdn.iconscout.com/icon/premium/png-256-thumb/sword-227-897949.png"),
                contentDescription = "sword",
                Modifier.fillMaxWidth())
            //github.com/huseyin-uslu
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Mainview2()
}

//in this tutorial , I've learned how to use other composables efficiently.