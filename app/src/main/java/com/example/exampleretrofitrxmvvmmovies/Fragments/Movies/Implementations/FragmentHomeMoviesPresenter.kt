package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.content.Context
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesBL
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesListener
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesPresenter
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesView
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse

class FragmentHomeMoviesPresenter (view : IFragmentHomeMoviesView):
    IFragmentHomeMoviesPresenter {

    private val selectView : IFragmentHomeMoviesView
    private val selectItemBL : IFragmentHomeMoviesBL

    init {
        this.selectView = view
        this.selectItemBL = FragmentHomeMoviesBL(Listener())
    }

    override fun callService() {
        selectItemBL.callService()
    }



    private inner class Listener : IFragmentHomeMoviesListener {
        override fun responseHomeMovies(movies: MoviesResponse) {
            selectView.responseHomeMovies(movies.results?.toMutableList()!!)
        }

        override fun failureService(response: MessageResponse) {
            selectView.failureService(response)
        }
    }
}