package com.abhat.thebestmovielines

import android.app.Application
import android.content.Context
import com.abhat.thebestmovielines.constants.Constants
import com.abhat.thebestmovielines.injection.*

/**
 * Created by Anirudh Uppunda on 13/01/18.
 */
class App: Application() {

    lateinit var appComponent: AppComponent
    lateinit var dataComponent: DataComponent

    companion object {
        private lateinit var context: App
        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initializeInjector()
    }

    private fun initializeInjector() {
        dataComponent =  DaggerDataComponent.builder()
                .dataModule(DataModule(Constants.BASE_URL, this))
                .build()

        appComponent = DaggerAppComponent.builder()
                .dataComponent(dataComponent)
                .appModule(AppModule())
                .build()
    }
}