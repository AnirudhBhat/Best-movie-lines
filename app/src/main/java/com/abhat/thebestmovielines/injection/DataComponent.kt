package com.abhat.thebestmovielines.injection

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Anirudh Uppunda on 24/2/18.
 */
@Singleton
@Component(modules = [DataModule::class])
interface DataComponent {
    fun getRetrofit(): Retrofit
}