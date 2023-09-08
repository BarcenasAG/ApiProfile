package com.example.apiprofile.domain

import com.example.apiprofile.data.remote.api.ResultApiService
import javax.inject.Inject

class FetchUserInfoUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend fun fetchUserInfo(): ResultApiService {
        return userRepository.fetchUserInfo()
    }
}
