package com.abhat.thebestmovielines.movielinesscreen.presentation

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.domain.UseCase
import javax.inject.Inject

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
class MovieLinesPresenterImpl @Inject constructor(movieLinesUseCase: UseCase<ResponseBody>){
    private lateinit var movieLinesView: MovieLinesView
    private val movieLinesUseCase: UseCase<ResponseBody> = movieLinesUseCase

    fun getMovieLines(accessToken: String, fields: String) {
        movieLinesView.showLoading()
        movieLinesUseCase.setQueryParams(accessToken, fields)
        movieLinesUseCase.execute()
                .subscribe({
                    onSuccess(it)
                }, {
                    onError(it)
                })
    }

    fun setView(view: MovieLinesView) {
        movieLinesView = view
    }

    private fun onSuccess(responseBody: ResponseBody) {
        movieLinesView.hideLoading()
        movieLinesView.onSuccess(responseBody)
    }

    private fun onError(error: Throwable) {
        movieLinesView.hideLoading()
        movieLinesView.onError(error)
    }
}