package com.example.apiprofile.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

data class CoroutinesDispatcher (val main: CoroutineDispatcher = Dispatchers.Main,
                                val default: CoroutineDispatcher = Dispatchers.Default,
                                val io: CoroutineDispatcher = Dispatchers.IO)
