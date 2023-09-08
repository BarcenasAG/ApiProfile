package com.example.apiprofile.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiprofile.data.remote.api.ResultApiService
import com.example.apiprofile.di.CoroutinesDispatcher
import com.example.apiprofile.domain.FetchUserInfoUseCase
import com.example.apiprofile.ui.models.UserModelUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Error
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val fetchUserInfoUseCase: FetchUserInfoUseCase,
                                        private val coroutinesDispatcher: CoroutinesDispatcher
                                        ): ViewModel() {

    private var _messageError = MutableLiveData<String>()
    val messageError get() = _messageError

    private var _userInfo = MutableLiveData<UserModelUi>()
    val userInfo get() = _userInfo

  fun getUserInformation(){
      viewModelScope.launch(coroutinesDispatcher.io) {
          val result = fetchUserInfoUseCase.fetchUserInfo()
          withContext(coroutinesDispatcher.main){
              when(result){
                  is ResultApiService.Success -> onSuccess(result.data)
                  is ResultApiService.Error -> onError(result.message)
              }
          }
      }
  }

    private fun onSuccess(data: UserModelUi) {
        _userInfo.value = data
    }

    private fun onError(message: String) {
        _messageError.value = message
    }
}
