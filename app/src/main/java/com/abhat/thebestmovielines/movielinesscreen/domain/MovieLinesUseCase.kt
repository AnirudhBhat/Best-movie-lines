package com.abhat.thebestmovielines.movielinesscreen.domain

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
open class MovieLinesUseCase @Inject constructor(private val movieLinesSource: MovieLinesRepository): UseCase<ResponseBody>() {

    override fun buildUseCase(): Single<ResponseBody> {
        return movieLinesSource.getMovieLines(accessToken, fields)
    }
}