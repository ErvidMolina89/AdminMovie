package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.content.Context
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesBL
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesListener
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesPresenter
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesView
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.Movie

class FragmentHomeMoviesPresenter (context: Context, view : IFragmentHomeMoviesView):
    IFragmentHomeMoviesPresenter {

    private val selectView : IFragmentHomeMoviesView
    private val context : Context
    private val selectItemBL : IFragmentHomeMoviesBL

    init {
        this.context = context
        this.selectView = view
        this.selectItemBL = FragmentHomeMoviesBL(Listener(), context)
    }

    override fun callService() {
        selectItemBL.callService()
    }



    private inner class Listener : IFragmentHomeMoviesListener {
        override fun responseHomeMovies(movies: MutableList<Movie>) {
            selectView.responseHomeMovies(movies)
        }

        override fun failureService(response: MessageResponse) {
            selectView.failureService(response)
        }
    }
}