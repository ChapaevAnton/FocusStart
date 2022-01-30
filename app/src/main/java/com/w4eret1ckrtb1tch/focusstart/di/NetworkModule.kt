package com.w4eret1ckrtb1tch.focusstart.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.w4eret1ckrtb1tch.focusstart.data.network.DailyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return builder
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(DailyApi.BASE_URL)
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

    @Provides
    @Singleton
    fun provideGsonClient(): Gson {
        return GsonBuilder()
            .setDateFormat(DailyApi.DATE_FORMAT)
            .create()
    }

}