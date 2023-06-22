package com.kerriganlove.core.network.di

import com.kerriganlove.core.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideSongHttpClient (
        okHttpClient : OkHttpClient
    ) : HttpClient {
        val httpClient = HttpClient(OkHttp) {
            engine {
                preconfigured = okHttpClient
                clientCacheSize = 100
                config {

                }
            }
            install(ContentNegotiation) {
                json()
            }
        }
        return httpClient
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(

    ) : OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            val interceptor = HttpLoggingInterceptor()
            if ( BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BASIC
            }
        }
        return okHttpClient.build()
    }
}