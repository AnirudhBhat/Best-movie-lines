package com.abhat.thebestmovielines.injection

import com.abhat.thebestmovielines.movielinesscreen.presentation.MovieLinesActivity
import dagger.Component

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(movieLinesActivity: MovieLinesActivity)
}