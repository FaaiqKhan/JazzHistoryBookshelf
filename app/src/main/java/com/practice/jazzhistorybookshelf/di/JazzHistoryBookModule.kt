package com.practice.jazzhistorybookshelf.di

import com.practice.jazzhistorybookshelf.data.network.JazzHistoryBookApiService
import com.practice.jazzhistorybookshelf.data.repository.DefaultJazzHistoryBookRepository
import com.practice.jazzhistorybookshelf.data.repository.JazzHistoryBookRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class JazzHistoryBookModule {

    @Provides
    fun provideJazzHistoryBooks(retrofit: Retrofit): JazzHistoryBookApiService = retrofit.create(
        JazzHistoryBookApiService::class.java
    )
}

@Module
@InstallIn(SingletonComponent::class)
fun interface JazzHistoryBookRepositoryModule {

    @Binds
    fun bindJazzHistoryRepository(defaultJazzHistoryBookRepository: DefaultJazzHistoryBookRepository): JazzHistoryBookRepository
}