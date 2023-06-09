package com.kerriganlove.core.data.di

import com.kerriganlove.core.data.repository.SongRepository
import com.kerriganlove.core.data.repository.SongRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindSongRepository(
        songRepository: SongRepositoryImpl
    ) : SongRepository
}