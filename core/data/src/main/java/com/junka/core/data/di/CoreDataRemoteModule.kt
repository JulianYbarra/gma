package com.junka.core.data.di

import com.junka.core.data.character.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreDataRemoteModule {

    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    @Provides
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService =
        retrofit.create<CharacterService>()
}

@Module
@InstallIn(SingletonComponent::class)
object CoreDataRemoteExtraModule {
    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl(): String = "https://rickandmortyapi.com/"
}