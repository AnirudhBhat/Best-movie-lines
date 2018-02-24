package com.abhat.thebestmovielines.movielinesscreen.domain

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import io.reactivex.Single

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
interface MovieLinesRepository {
    fun getMovieLines(accessToken: String, fields: String): Single<ResponseBody>
}