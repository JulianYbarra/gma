package com.junka.core.testing.di

import com.junka.core.data.di.BaseUrl
import com.junka.core.data.di.CoreDataRemoteExtraModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoreDataRemoteExtraModule::class],
)
internal object TestCoreDataRemoteModule {

    @Provides
    @Singleton
    @BaseUrl
    fun provideApiUrl(): String = "http://localhost:8080"

}