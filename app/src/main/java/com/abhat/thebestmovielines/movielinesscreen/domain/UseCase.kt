package com.abhat.thebestmovielines.movielinesscreen.domain

import io.reactivex.Single


/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
abstract class UseCase<T> {

    lateinit var accessToken: String
    lateinit var fields: String

    abstract fun buildUseCase(): Single<T>

    fun execute(): Single<T> {
        return buildUseCase()
    }

    fun setQueryParams(accessToken: String, fields: String) {
        this.accessToken = accessToken
        this.fields = fields
    }
}