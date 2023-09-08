package com.example.apiprofile.domain

import com.example.apiprofile.data.remote.api.RemoteDataBase
import com.example.apiprofile.data.remote.api.ResultApiService
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDataBase: RemoteDataBase) {

    suspend fun fetchUserInfo():  ResultApiService{
        return remoteDataBase.getUserInformation()
    }
}
