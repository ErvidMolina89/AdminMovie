package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesPresenter
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesView
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.R

interface ChangeFragmentListener {
    fun onChangeFragment(movie: Movie)
}

class FragmentMovie : Fragment() {

    private var changeFragmentListener: ChangeFragmentListener? = null
    private var rv_movies_list: RecyclerView? = null
    private var presenter: IFragmentHomeMoviesPresenter? = null
    private var actionPresenter = actionViewPresenter()
    private var adapter: MovieRecyclerViewAdapter = MovieRecyclerViewAdapter(emptyList<Movie>().toMutableList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        rv_movies_list = view.findViewById(R.id.recyclerView)
        presenter = FragmentHomeMoviesPresenter( actionPresenter)
        recyclerView()
        listenerRevycler()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verifica que la actividad contenedora implemente la interfaz
        if (context is ChangeFragmentListener) {
            changeFragmentListener = context
        } else {
            throw RuntimeException("$context debe implementar CambioActividadListener")
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.callService()
    }

    private fun recyclerView (){
        rv_movies_list?.layoutManager = LinearLayoutManager(context)
        rv_movies_list?.adapter = adapter
    }

    private fun listenerRevycler(){
        adapter.onClickListener {
            changeFragmentListener?.onChangeFragment(it)
        }
    }

    inner class actionViewPresenter: IFragmentHomeMoviesView {
        override fun failureService(response: MessageResponse) {
            print("${response.Message}")
        }

        override fun responseHomeMovies(movies: MutableList<Movie>) {
            adapter.setData(movies)
        }
    }
}