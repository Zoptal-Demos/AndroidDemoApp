package com.zoptal.munzul.retrofit

import android.util.Log
import retrofit2.Retrofit
import com.google.gson.GsonBuilder

import com.zoptal.munzul.constants.ApiConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.Interceptor
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import java.util.prefs.Preferences


class RetroInstance {
    companion object {

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = OkHttpClient.Builder()
            .pingInterval(ApiConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

            .addInterceptor(getLoggin()!!)
            .addInterceptor(Interceptor {
                    chain: Interceptor.Chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Connection"," keep-alive")
                    .addHeader("Content-Type","application/json")
                    .addHeader("Accept","application/json")
                    .build()
                chain.proceed(newRequest)
            })
            .build()

        fun getLoggin(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return logging
        }

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create()) //important
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .build()
        }
    }
}