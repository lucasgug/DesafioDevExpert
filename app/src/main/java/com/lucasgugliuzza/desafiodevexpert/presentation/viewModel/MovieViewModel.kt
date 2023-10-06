package com.lucasgugliuzza.desafiodevexpert.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasgugliuzza.desafiodevexpert.data.dto.ResultDto
import com.lucasgugliuzza.desafiodevexpert.data.remote.MovieApi
import com.lucasgugliuzza.desafiodevexpert.domain.repository.MovieRepository
import com.lucasgugliuzza.desafiodevexpert.presentation.MovieState
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository = MovieRepository(MovieApi.instance)
) : ViewModel() {

    var state by mutableStateOf(MovieState())
        private set

    init {
        viewModelScope.launch {
            repository.getMovies().onSuccess {
                state = state.copy(
                    listamovies = it
                )
            }.onFailure {
                println("ERROR")
            }
        }
    }
}