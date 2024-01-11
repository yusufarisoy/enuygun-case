package com.yusufarisoy.enuyguncase.di

import com.yusufarisoy.enuyguncase.data.repository.ApiRepository
import com.yusufarisoy.enuyguncase.data.repository.ApiRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun provideApiRepository(impl: ApiRepositoryImpl): ApiRepository
}
