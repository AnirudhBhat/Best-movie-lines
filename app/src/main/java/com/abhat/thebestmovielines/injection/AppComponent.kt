package com.abhat.thebestmovielines.injection

import com.abhat.bytemarkassignment.dagger.scope.CustomScoped
import com.abhat.thebestmovielines.movielinesscreen.presentation.MovieLinesActivity
import dagger.Component

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */
@CustomScoped
@Component(modules = arrayOf(AppModule::class),
        dependencies = arrayOf(DataComponent::class))
interface AppComponent {
    fun inject(movieLinesActivity: MovieLinesActivity)
}