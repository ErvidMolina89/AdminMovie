package com.example.exampleretrofitrxmvvmmovies

import android.os.Bundle
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Base.BaseActivity
import com.example.exampleretrofitrxmvvmmovies.Fragments.DetailsMovieFragment
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations.ChangeFragmentListener
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations.FragmentMovie
import com.example.exampleretrofitrxmvvmmovies.Models.Movie

class MainActivity : BaseActivity(), ChangeFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.mContext = this
        showFragment(FragmentMovie(), R.id.fragment_home)
    }

    override fun onChangeFragment(movie: Movie) {
        val fragment = DetailsMovieFragment()
        val bundle = Bundle()
        bundle.putSerializable("movie", movie)
        fragment.arguments = bundle
        navigationEntreFragment(R.id.fragment_home, null, fragment)
    }
}