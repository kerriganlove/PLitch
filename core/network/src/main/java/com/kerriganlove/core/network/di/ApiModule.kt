package com.kerriganlove.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import okhttp3.OkHttpClient
import okhttp3.internal.platform.AndroidPlatform
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideHttpClient(
        okHttpClient : OkHttpClient
    ) : HttpClient{
        val httpClient = HttpClient() {

        }

        return httpClient
    }
}