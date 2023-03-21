package com.simplemobiletools.dialer.services

import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.helpers.TYPE
import com.simplemobiletools.dialer.interfaces.TrueCallerApi
import com.simplemobiletools.dialer.models.truecaller.TrueCallerResponse
import retrofit2.Response

class TrueCallerService {

    suspend fun getTrueCallerResponse(countryCode: String, mobileNumber: String, authorizationToken: String, networkConnectionInterceptor: NetworkConnectionInterceptor): Response<TrueCallerResponse> {
        return TrueCallerApi.invoke(networkConnectionInterceptor).getTrueCallerResponse(countryCode,mobileNumber,TYPE,authorizationToken)
    }
}
