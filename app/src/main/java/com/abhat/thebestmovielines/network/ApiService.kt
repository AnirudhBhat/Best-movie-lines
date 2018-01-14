package com.abhat.thebestmovielines.network

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
interface ApiService {
    @GET("photos/uploaded/")
    fun getMovieLines(@Query("access_token") accessToken: String, @Query("fields") fields: String): Single<ResponseBody>
}