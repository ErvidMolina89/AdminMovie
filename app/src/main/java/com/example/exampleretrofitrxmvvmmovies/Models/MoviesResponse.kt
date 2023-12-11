package com.example.exampleretrofitrxmvvmmovies.Models

class MoviesResponse {
    var status_code             : Int? = null
    var number_of_page_results  : Int? = null
    var number_of_total_results : Int? = null
    var results                 : MutableList<Movie>? = null
}