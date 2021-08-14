package com.firstprojects.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstprojects.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme
import com.firstprojects.jetpackcomposebasics.ui.theme.Purple200

//jetpack compose basics
//LazyColumn,Hosting State,Animation,Composables,Themes...etc
//In this project , I've applied the tutorial -> https://www.youtube.com/watch?v=qvDo0SKR8-k

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
               MyScreenView()
            }
        }
    }
}


@Composable
fun MyApp(content : @Composable  ()-> Unit){
    JetpackComposeBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun MyScreenView(names : List<String> = List<String>(1000){
    "Hello Jetpack Compose $it"
}){
    var counterState by remember {
        mutableStateOf(0)
    }

    Column (modifier = Modifier.fillMaxSize()){
        NamesList(names = names,modifier = Modifier.weight(1f))

        Counter(counterState){ updatedCount->
            counterState =  updatedCount
        }

    }
}

@Composable
fun NamesList(names : List<String>, modifier : Modifier = Modifier){
    LazyColumn(modifier = modifier){
        items(items = names){
            Greeting(it)
            Divider(thickness = 20.dp,color = Purple200,modifier = Modifier.padding(all = 5.dp))
        }

    }
}

@Composable
fun Counter(count : Int, updateCount : (Int)->Unit){
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
        Button(onClick = { updateCount(count + 1)}){
            Text("I've been clicked $count times.")
        }
    }

}

//DONT DELETE UPLOAD THIS TO GITHUB
@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    val targetColor by animateColorAsState(targetValue = if(isSelected) MaterialTheme.colors.primary else Color.Transparent,
        animationSpec = tween(2000)) {

    }
    Surface(color = targetColor){
        Text(text = "Hello $name!",modifier = Modifier
            .clickable{isSelected = !isSelected}
            .padding(all = 16.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MyApp(){
       MyScreenView()
   }
}//DONT DELETE UPLOAD THIS TO GITHUB