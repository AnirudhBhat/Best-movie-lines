package com.abhat.thebestmovielines.movielinesscreen.data.source

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesRepository
import com.abhat.thebestmovielines.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
open class MovieLinesSource(private val apiService: ApiService): MovieLinesRepository {
    override fun getMovieLines(accessToken: String, fields: String): Single<ResponseBody> {
        return  apiService.getMovieLines(accessToken, fields)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}