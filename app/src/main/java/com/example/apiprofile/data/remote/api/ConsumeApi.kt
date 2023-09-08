package com.example.apiprofile.data.remote.api


import com.example.apiprofile.data.models.ProfileModelData
import retrofit2.Response
import retrofit2.http.GET

interface ConsumeApi {
    @GET(USER_END_POINT)
    suspend fun getRandomUsers(): Response<ProfileModelData>

    companion object {
        private const val USER_END_POINT = "api"
    }
}
