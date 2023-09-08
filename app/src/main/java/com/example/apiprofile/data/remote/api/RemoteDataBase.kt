package com.example.apiprofile.data.remote.api

import com.example.apiprofile.data.models.toUserModelUI
import javax.inject.Inject

class RemoteDataBase @Inject constructor(private val consumeApi: ConsumeApi) {

    suspend fun getUserInformation() : ResultApiService {

        return try {
            val response = consumeApi.getRandomUsers()
            val data = response.body()
            if (data != null) ResultApiService.Success(data.toUserModelUI())
            else ResultApiService.Error("Response body is null")
        } catch (e: Exception) {
            ResultApiService.Error("An error occurred: ${e.message}")
        }
    }
}