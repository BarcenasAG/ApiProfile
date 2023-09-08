package com.example.apiprofile.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesDispatcherModule  {

    @Provides
    fun providesCoroutinesDispatchers(): CoroutinesDispatcher {
        return CoroutinesDispatcher()
    }
}
