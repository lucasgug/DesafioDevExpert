package com.lucasgugliuzza.desafiodevexpert.presentation

import com.lucasgugliuzza.desafiodevexpert.data.dto.ResultDto


data class MovieState(
    val listamovies: List<ResultDto> = emptyList(),
    val isFavorite: Boolean = false
)
