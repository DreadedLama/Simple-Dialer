package com.simplemobiletools.dialer.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.services.TrueCallerService
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val trueCallerService: TrueCallerService) : ViewModel() {

    val trueCallerResponse: MutableLiveData<List<TrueCallerDataResponse>> = MutableLiveData()

    fun getResponse(mobileNumber: String, authorizationToken: String, networkConnectionInterceptor: NetworkConnectionInterceptor) {
        viewModelScope.launch {
            val response: Response<TrueCallerResponse> =
                trueCallerService.getTrueCallerResponse(mobileNumber, authorizationToken, networkConnectionInterceptor)
            trueCallerResponse.value = response.body()?.data
        }
    }
}
