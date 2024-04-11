package com.zoptal.munzul.di.module

import android.content.Context
import android.content.SharedPreferences
import android.media.AudioManager
import android.preference.PreferenceManager
import com.zoptal.munzul.constants.ApiConstants
import com.zoptal.munzul.retrofit.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton



@Module
class AppModule {




    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    fun provideSharedPrefrence(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)

    }


    @Singleton
    @Provides
    fun provideAudioManager(context: Context): AudioManager {
        return context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }


}