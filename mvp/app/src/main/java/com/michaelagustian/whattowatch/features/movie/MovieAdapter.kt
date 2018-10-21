package com.michaelagustian.whattowatch.features.movie

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.michaelagustian.whattowatch.R
import com.michaelagustian.whattowatch.features.moviedetail.MovieDetailActivity
import com.michaelagustian.whattowatch.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.item_movie_poster.view.*

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var movies = ArrayList<Movie>()
        private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bind(movie: Movie) {
        itemView.apply {
            img_movie_poster.setImageURI(movie.getPoster())
            tv_movie_title.text = movie.title
            tv_movie_rating.text = movie.voteAverage.toString()
            btn_movie_detail.setOnClickListener { context.startActivity(MovieDetailActivity.getStartIntent(context, movie.id!!)) }
        }
    }
}