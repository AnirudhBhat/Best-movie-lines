package com.abhat.thebestmovielines.network

import android.util.Log
import com.abhat.thebestmovielines.App
import com.abhat.thebestmovielines.constants.Constants
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Anirudh Uppunda on 13/1/18.
 */
class RestClient {


    private fun RestClient() {

    }

    companion object {
        lateinit var retrofit: Retrofit
        fun getInstance(): Retrofit {
            return retrofit
        }

        fun getApiService(): ApiService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                    .addInterceptor(provideOfflineCacheInterceptor())
                    .addNetworkInterceptor(provideCacheInterceptor())
                    .addInterceptor(logging)
                    .cache(provideCache())
                    .build()

            retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    //.client(MockClient(App.getContext()))
                    .client(client)
                    .build()
            return retrofit.create<ApiService>(ApiService::class.java)
        }

        private fun provideCache(): Cache? {
            var cache: Cache? = null
            try {
                cache = Cache(File(App.getContext().cacheDir, "http-cache"),
                        (10 * 1024 * 1024).toLong()) // 10 MB
            } catch (e: Exception) {
                Log.e("OKHTTP", "Could not create Cache!")
            }

            return cache
        }

        fun provideCacheInterceptor(): Interceptor {
            return Interceptor { chain ->
                val response = chain.proceed(chain.request())

                // re-write response header to force use of cache
                val cacheControl = CacheControl.Builder()
                        .maxAge(2, TimeUnit.MINUTES)
                        .build()

                response.newBuilder()
                        .header("Cache-Control", cacheControl.toString())
                        .removeHeader("Pragma")
                        .build()
            }
        }

        fun provideOfflineCacheInterceptor(): Interceptor {
            return Interceptor { chain ->
                var request = chain.request()

                if (!Utils.isOnline()) {
                val cacheControl = CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build()

                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .removeHeader("Pragma")
                        .build()
                }

                chain.proceed(request)
            }
        }
    }

}