package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces

import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse

interface IFragmentHomeMoviesView {
    fun failureService(response: MessageResponse)
    fun responseHomeMovies(movies: MutableList<Movie>)
}