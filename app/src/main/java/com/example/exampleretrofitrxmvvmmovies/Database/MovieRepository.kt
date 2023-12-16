package com.example.exampleretrofitrxmvvmmovies.Database

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Models.MessageResponse
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse
import com.example.exampleretrofitrxmvvmmovies.R
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.ObservableEmitter


class MovieRepository (callback: IResponder): IMovieResponder {

    private val callback: IResponder

    init{
        this.callback = callback
    }

    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(App.mContext!!)
    }

    override fun getMovies() {
        val url = App.mContext!!.getString(R.string.url)

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val gson = Gson()
                val movieResponse = gson.fromJson(response.toString(), MoviesResponse::class.java)
                callback.onSuccess(movieResponse)
            },
            { error ->
                callback.onError(MessageResponse(error.hashCode().toString(), error.message))
            })

        requestQueue.add(request)
    }
}

