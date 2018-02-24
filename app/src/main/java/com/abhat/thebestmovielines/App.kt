package com.abhat.thebestmovielines

import android.app.Application
import android.content.Context
import com.abhat.thebestmovielines.injection.AppComponent
import com.abhat.thebestmovielines.injection.AppModule
import com.abhat.thebestmovielines.injection.DaggerAppComponent

/**
 * Created by Anirudh Uppunda on 13/01/18.
 */
class App: Application() {

    companion object {
        private lateinit var context: App
        lateinit var appComponent: AppComponent

        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        appComponent =  DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
    }
}