package com.simplemobiletools.dialer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.models.TrueCallerResponse
import com.simplemobiletools.dialer.services.TrueCallerService
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val trueCallerService: TrueCallerService) : ViewModel() {

    val myResponse: MutableLiveData<Response<TrueCallerResponse>> = MutableLiveData()

    fun getResponse(mobileNumber: String, authorizationToken: String, networkConnectionInterceptor: NetworkConnectionInterceptor) {
        viewModelScope.launch {
            val response: Response<TrueCallerResponse> =
                trueCallerService.getTrueCallerResponse(mobileNumber, authorizationToken, networkConnectionInterceptor)
            myResponse.value = response
        }
    }
}
