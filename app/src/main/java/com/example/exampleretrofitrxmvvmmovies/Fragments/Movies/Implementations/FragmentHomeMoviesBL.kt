package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.annotation.SuppressLint
import android.content.Context
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Database.IMovieResponder
import com.example.exampleretrofitrxmvvmmovies.Database.IResponder
import com.example.exampleretrofitrxmvvmmovies.Database.MovieRepository
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesBL
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesListener
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse
import com.example.exampleretrofitrxmvvmmovies.utils.isNetworkAvailable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FragmentHomeMoviesBL (listener : IFragmentHomeMoviesListener):
    IFragmentHomeMoviesBL {

    private val listener : IFragmentHomeMoviesListener
    private val movieRepository: IMovieResponder?

    init {
        this.listener = listener
        this.movieRepository = MovieRepository(responderMovieRepsitory())
    }

    @SuppressLint("CheckResult")
    override fun callService() {
        try {
            if (isNetworkAvailable(App.mContext!!)) {
                movieRepository?.getMovies()
            }
        } catch (e: Exception) {
            print("Error: ${e.message}")
        }

    }

    private inner class responderMovieRepsitory : IResponder {
        override fun onSuccess(moviesResponse: MoviesResponse) {
            listener.responseHomeMovies(moviesResponse)
        }

        override fun onError(error: MessageResponse) {
            listener.failureService(error)
        }
    }

}

