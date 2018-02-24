package com.abhat.thebestmovielines.movielinesscreen.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.abhat.thebestmovielines.App
import com.abhat.thebestmovielines.R
import com.abhat.thebestmovielines.constants.Constants
import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesUseCase
import javax.inject.Inject

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */
class MovieLinesActivity: AppCompatActivity(), MovieLinesView {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    private lateinit var movieLinesAdapter: MovieLinesRecyclerAdapter
    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress_bar) }

    @Inject
    lateinit var movieLinesPresenter: MovieLinesPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
        //App.appComponent.inject(this)
        setupRecyclerAdapter()
        showLoading()
        //movieLinesPresenter = MovieLinesPresenterImpl(this, MovieLinesUseCase())
        movieLinesPresenter.setView(this)
        movieLinesPresenter.getMovieLines(Constants.ACCESS_TOKEN, Constants.FIELD)
    }


    private fun setupRecyclerAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        movieLinesAdapter = MovieLinesRecyclerAdapter(mutableListOf(), this)
        recyclerView.adapter = movieLinesAdapter
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onSuccess(responseBody: ResponseBody) {
        movieLinesAdapter.setDataList(responseBody.data)
        movieLinesAdapter.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        error.printStackTrace()
    }
}