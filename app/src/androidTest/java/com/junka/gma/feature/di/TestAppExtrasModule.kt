package com.junka.gma.feature.di

import androidx.compose.runtime.NoLiveLiterals
import com.junka.gma.core.di.BaseUrl
import com.junka.gma.core.di.CoreDataRemoteExtraModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoreDataRemoteExtraModule::class]
)
@Module
object TestAppExtrasModule {
    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl(): String = "http://localhost:8080"

}