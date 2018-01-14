package com.abhat.thebestmovielines.movielinesscreen.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.abhat.thebestmovielines.R
import com.abhat.thebestmovielines.R.id.save
import com.abhat.thebestmovielines.R.id.share
import com.abhat.thebestmovielines.movielinesscreen.data.response.data
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */
class MovieLinesRecyclerAdapter(var data: List<data>, val context: Context): RecyclerView.Adapter<MovieLinesRecyclerAdapter.MyViewHolder>() {

    private var animation: AnimationSet? = null
    private lateinit var image: ImageView

    fun setDataList(data: List<data>) {
        this.data = data
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById<View>(R.id.image) as ImageView
        var text: TextView = itemView.findViewById<View>(R.id.text) as TextView
        var save: Button = itemView.findViewById<View>(R.id.save) as Button
        var share: Button = itemView.findViewById<View>(R.id.share) as Button
        //var progressBar: ProgressBar = itemView.findViewById<View>(R.id.progressBar) as ProgressBar

        fun bind(imageUrl: String?, movieName: String?, sharePosition: Int?, savePosition: Int?) {
            text.text = movieName
            Glide.with(context).load(imageUrl).thumbnail(0.1f).into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_lines_single_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, listPosition: Int) {

        val movieName: String = data[listPosition].name
        val movieUrl: String = data[listPosition].images[0].source
        holder.bind(movieUrl, movieName, listPosition, listPosition)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /*private fun setupAnimation() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() // add this
        fadeIn.duration = 5000
        animation = AnimationSet(false) // change to false
        animation.addAnimation(fadeIn)
    }*/
}