package com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleretrofitrxmvvmmovies.Base.App
import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.R
import de.hdodenhof.circleimageview.CircleImageView

class MovieRecyclerViewAdapter(
    private var mValues: List<Movie>
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    private var listener: ((Movie)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.tv_name.text   = item.name
        holder.tv_rutime.text = item.runtime
        holder.tv_date.text   = item.release_date
        Glide.with(App.mContext!!).load(item.image?.original_url).into(holder.tv_icon)

        setListeners(holder,item)
    }

    private fun setListeners(holder : ViewHolder, item : Movie){
        holder.mView
            .setOnClickListener {
                listener?.invoke(item)
            }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val tv_icon   : ImageView = mView.findViewById(R.id.ivc_avatar)
        val tv_name   : TextView = mView.findViewById(R.id.tv_title_name)
        val tv_rutime : TextView = mView.findViewById(R.id.tv_type_rutime)
        val tv_date   : TextView = mView.findViewById(R.id.tv_date)

    }

    fun onClickListener(listener : (Movie)-> Unit){
        this.listener = listener
    }

    fun setData(listSearch : List<Movie>){
        this.mValues = listSearch
        notifyDataSetChanged()
    }
}