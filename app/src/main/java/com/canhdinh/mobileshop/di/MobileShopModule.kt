package com.canhdinh.mobileshop.di

import com.canhdinh.mobileshop.BuildConfig.DEBUG
import com.canhdinh.mobileshop.network.ApiService
import com.canhdinh.mobileshop.util.Constants.BASE_URL
import com.canhdinh.mobileshop.util.Constants.CONNECT_TIMEOUT
import com.canhdinh.mobileshop.util.Constants.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MobileShopModule {

    @Provides
    fun providerApiInterface(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providerOkHttpClient(): OkHttpClient {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)

        val logging = HttpLoggingInterceptor()
        if (DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.BASIC
        }

        okHttpClient.addInterceptor(logging)
        return okHttpClient.build()
    }

    /*
     context in @Module :
        (@ApplicationContext context: Context)
     */
}