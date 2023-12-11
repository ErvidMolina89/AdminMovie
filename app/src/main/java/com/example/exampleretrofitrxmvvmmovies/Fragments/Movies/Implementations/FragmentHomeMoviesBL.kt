package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.annotation.SuppressLint
import android.content.Context
import com.example.exampleretrofitrxmvvmmovies.Database.MovieRepository
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesBL
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesListener
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse
import com.example.exampleretrofitrxmvvmmovies.utils.isNetworkAvailable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FragmentHomeMoviesBL (listener : IFragmentHomeMoviesListener, context: Context):
    IFragmentHomeMoviesBL {

    private val context : Context
    private val listener : IFragmentHomeMoviesListener
    private val movieRepository: MovieRepository?

    init {
        this.context = context
        this.listener = listener
        this.movieRepository = MovieRepository()
    }

    @SuppressLint("CheckResult")
    override fun callService() {
        try {
            if (isNetworkAvailable(context)) {
                movieRepository?.getMovies()
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe(
                        { handleResponse(it) },
                        { handleError(it) })
            }
        } catch (e: Exception) {
            print("Error: ${e.message}")
        }

    }

    private fun handleResponse(response: MoviesResponse) {
        listener.responseHomeMovies(response.results?.toMutableList()!!)
    }

    private fun handleError(error: Throwable) {
        listener.failureService(MessageResponse(error.hashCode().toString(), error.message))
    }

}

