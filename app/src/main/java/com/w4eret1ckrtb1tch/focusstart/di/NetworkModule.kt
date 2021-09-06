package com.w4eret1ckrtb1tch.focusstart.di

import com.google.gson.Gson
import com.w4eret1ckrtb1tch.focusstart.data.source.DailyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL = "https://www.cbr-xml-daily.ru/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideDailyApi(retrofit: Retrofit): DailyApi {
        return retrofit.create(DailyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        builder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return builder
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

}