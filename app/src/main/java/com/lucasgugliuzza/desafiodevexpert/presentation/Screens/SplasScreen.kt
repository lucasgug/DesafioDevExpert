package com.lucasgugliuzza.desafiodevexpert.presentation.Screens


import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucasgugliuzza.desafiodevexpert.R
import com.lucasgugliuzza.desafiodevexpert.ui.theme.Pink40
import com.lucasgugliuzza.desafiodevexpert.ui.theme.Purple40
import org.w3c.dom.Text

@Composable
fun SplashScreen() {

    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale",

    )

  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
       modifier = Modifier
           .fillMaxSize()
           .background(
               Brush.verticalGradient(
                   colors = listOf(
                       Purple40,
                       Pink40,
                   )
               )
           )
   ){
       Text(text = "Movies for everyone", color = Color.White,
           modifier = Modifier.graphicsLayer(scale),
           fontFamily = FontFamily.Serif ,
           fontWeight = FontWeight.Bold,
           fontSize = 26.sp
       )
       Image(
           painter = painterResource(id = R.drawable.pngegg) ,
           contentDescription = "",
           modifier = Modifier.padding(top = 20.dp)

       )
   }
}







