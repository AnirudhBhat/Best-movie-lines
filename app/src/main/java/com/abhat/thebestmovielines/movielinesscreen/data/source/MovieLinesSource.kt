package com.abhat.thebestmovielines.movielinesscreen.data.source

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesRepository
import com.abhat.thebestmovielines.network.RestClient
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
open class MovieLinesSource: MovieLinesRepository {
    override fun getMovieLines(accessToken: String, fields: String): Single<ResponseBody> {
        return RestClient.getApiService().getMovieLines(accessToken, fields)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}