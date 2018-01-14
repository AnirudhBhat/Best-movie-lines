package com.abhat.thebestmovielines.injection

import android.content.Context
import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.data.source.MovieLinesSource
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesRepository
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesUseCase
import com.abhat.thebestmovielines.movielinesscreen.domain.UseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideMovieLinesRepository(): MovieLinesRepository {
        return MovieLinesSource()
    }

    @Provides
    fun provideMovieLinesUseCase(): UseCase<ResponseBody> {
        return MovieLinesUseCase(MovieLinesSource())
    }
}