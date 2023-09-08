package com.example.apiprofile.data.remote.api

import com.example.apiprofile.ui.models.UserModelUi

sealed class ResultApiService {
    data class Success(val data: UserModelUi) : ResultApiService()
    data class Error(val message: String) : ResultApiService()
}
