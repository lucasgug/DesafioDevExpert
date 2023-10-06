package com.lucasgugliuzza.desafiodevexpert.presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lucasgugliuzza.desafiodevexpert.data.dto.MovieResult
import com.lucasgugliuzza.desafiodevexpert.data.dto.ResultDto
import com.lucasgugliuzza.desafiodevexpert.presentation.viewModel.MovieViewModel
import com.lucasgugliuzza.desafiodevexpert.ui.theme.PurpleGrey40


@Composable
fun HomeScreen(
    movieviewModel: MovieViewModel
) {

    val state = movieviewModel.state

    if (state.listamovies.isNotEmpty()){
        LazyVerticalGrid(
            modifier = Modifier.background(PurpleGrey40),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,


        ){
            items(state.listamovies){

                   item(it, { movieviewModel.onMovieClick(it) })

            }
        }
    }
}

@Composable
fun item(resultDto: ResultDto,onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        ) {
        Text(
            text = resultDto.original_title,
            modifier = Modifier,
            fontSize = 16.sp,
            maxLines = 1
        )
    Box {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${resultDto.poster_path}",
            contentDescription = resultDto.original_title
        )

        if (resultDto.favorite){
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .clickable(onClick = onClick),
                tint = Color.Red
            )
        }else{
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .clickable(onClick = onClick),
                tint = Color.Red
            )
        }
      }
    }
}
