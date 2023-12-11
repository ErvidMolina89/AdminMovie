package com.example.exampleretrofitrxmvvmmovies.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.R
import com.example.exampleretrofitrxmvvmmovies.utils.convertirDate
import com.example.exampleretrofitrxmvvmmovies.utils.removePTags

class DetailsMovieFragment : Fragment() {

    private var movie: Movie? = null

    private var iv_detail_movie: ImageView? = null
    private var tv_name_detail: TextView? = null
    private var tv_date_detail: TextView? = null
    private var tv_rutime_detail: TextView? = null
    private var tv_deck_detail: TextView? = null
    private var tv_total_revenue: TextView? = null
    private var tv_description_detail: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        iv_detail_movie = view.findViewById(R.id.iv_detail_movie)
        tv_name_detail = view.findViewById(R.id.tv_name_detail)
        tv_date_detail = view.findViewById(R.id.tv_date_detail)
        tv_rutime_detail = view.findViewById(R.id.tv_rutime_detail)
        tv_deck_detail = view.findViewById(R.id.tv_deck_detail)
        tv_total_revenue = view.findViewById(R.id.tv_total_revenue)
        tv_description_detail = view.findViewById(R.id.tv_description_detail)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Recuperar el modelo pasado como argumento
        movie = arguments?.getSerializable("movie") as Movie?

        // Hacer lo que necesites con el modelo
        if (movie != null) {
            visualizationInfoView(movie!!)
        }
    }

    private fun visualizationInfoView(movie: Movie) {
        iv_detail_movie?.let { Glide.with(App.mContext!!).load(movie.image?.original_url).into(it) }
        tv_name_detail?.text = movie.name?.toUpperCase()
        tv_date_detail?.text  = movie.release_date?.convertirDate()
        tv_rutime_detail?.text  = movie.runtime
        tv_deck_detail?.text  = movie.deck
        tv_total_revenue?.text  = movie.total_revenue
        tv_description_detail?.text  = movie.description?.removePTags()
    }
}