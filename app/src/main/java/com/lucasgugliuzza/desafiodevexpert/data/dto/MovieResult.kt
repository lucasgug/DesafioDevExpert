package com.lucasgugliuzza.desafiodevexpert.data.dto

data class MovieResult(
    val page: Int,
    val results: List<ResultDto>,
    val total_pages: Int,
    val total_results: Int
)