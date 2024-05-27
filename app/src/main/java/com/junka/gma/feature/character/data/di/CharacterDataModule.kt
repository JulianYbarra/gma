package com.junka.gma.feature.character.data.di

import com.junka.gma.feature.character.data.CharacterRemoteDataSourceImp
import com.junka.gma.feature.character.data.CharacterRepositoryImpl
import com.junka.gma.feature.character.data.CharacterService
import com.junka.gma.feature.character.domain.CharacterRemoteDataSource
import com.junka.gma.feature.character.domain.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDataModule {

    @Binds
    abstract fun bindCharacterRemoteDataSource(impl: CharacterRemoteDataSourceImp): CharacterRemoteDataSource

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository


    companion object {
        @Provides
        fun provideCharacterService(retrofit: Retrofit): CharacterService =
            retrofit.create<CharacterService>()
    }

}