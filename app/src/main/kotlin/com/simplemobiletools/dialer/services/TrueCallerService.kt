package com.simplemobiletools.dialer.services

import com.simplemobiletools.dialer.helpers.COUNTRY_CODE
import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.helpers.TYPE
import com.simplemobiletools.dialer.interfaces.TrueCallerApi
import com.simplemobiletools.dialer.models.TrueCallerResponse
import retrofit2.Response

class TrueCallerService {

    suspend fun getTrueCallerResponse(mobileNumber: String, authorizationToken: String, networkConnectionInterceptor: NetworkConnectionInterceptor): Response<TrueCallerResponse> {
        return TrueCallerApi.invoke(networkConnectionInterceptor).getTrueCallerResponse(COUNTRY_CODE,mobileNumber,TYPE,authorizationToken)
    }
}
