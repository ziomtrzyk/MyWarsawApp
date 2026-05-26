package com.example.mywarsawapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MyWarsawAppTheme
import com.example.mywarsawapp.ui.MyWarsawApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWarsawAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val windowSize = calculateWindowSizeClass(this)
                    MyWarsawApp(windowSize.widthSizeClass)
                }
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 1000)
@Composable
fun MyWarsawAppExpandedPreview(){
    MyWarsawAppTheme() {
        MyWarsawApp(windowSize = WindowWidthSizeClass.Expanded)
    }
}

