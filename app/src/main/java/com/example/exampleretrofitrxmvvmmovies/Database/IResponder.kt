package com.example.exampleretrofitrxmvvmmovies.Database

import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse

interface IResponder {
    fun onSuccess(moviesResponse: MoviesResponse)
    fun onError(error: MessageResponse)
}