package com.abhat.thebestmovielines.movielinesscreen.presentation

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
interface MovieLinesView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(responseBody: ResponseBody)
    fun onError(error: Throwable)
}