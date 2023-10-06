package com.lucasgugliuzza.desafiodevexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lucasgugliuzza.desafiodevexpert.presentation.Screens.Navigation
import com.lucasgugliuzza.desafiodevexpert.presentation.viewModel.MovieViewModel
import com.lucasgugliuzza.desafiodevexpert.ui.theme.DesafioDevExpertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    val movieviewModel by viewModels<MovieViewModel>()
                    Navigation(movieviewModel)


        }
    }
}

