package com.junka.core.data.di

import com.junka.core.data.character.CharacterRemoteDataSourceImp
import com.junka.core.data.character.CharacterRepositoryImpl
import com.junka.core.domain.character.CharacterRemoteDataSource
import com.junka.core.domain.character.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreDataModule {
    @Binds
    abstract fun bindCharacterRemoteDataSource(impl: CharacterRemoteDataSourceImp): CharacterRemoteDataSource

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

}