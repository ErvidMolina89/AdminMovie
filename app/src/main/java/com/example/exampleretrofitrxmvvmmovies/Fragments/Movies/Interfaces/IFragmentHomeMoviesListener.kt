package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces

import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse

interface IFragmentHomeMoviesListener {
    fun failureService(response: MessageResponse)
    fun responseHomeMovies(movies: MoviesResponse)
}