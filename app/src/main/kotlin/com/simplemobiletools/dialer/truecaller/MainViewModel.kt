package com.simplemobiletools.dialer.truecaller

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.models.truecaller.TrueCallerDataResponse
import com.simplemobiletools.dialer.models.truecaller.TrueCallerResponse
import com.simplemobiletools.dialer.services.TrueCallerService
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val trueCallerService: TrueCallerService) : ViewModel() {

    val trueCallerResponse: MutableLiveData<List<TrueCallerDataResponse>> = MutableLiveData()

    fun getResponse(countryCode: String, mobileNumber: String, authorizationToken: String, networkConnectionInterceptor: NetworkConnectionInterceptor) {
        viewModelScope.launch {
            val response: Response<TrueCallerResponse> =
                trueCallerService.getTrueCallerResponse(countryCode, mobileNumber, authorizationToken, networkConnectionInterceptor)
            trueCallerResponse.value = response.body()?.data
        }
    }
}
