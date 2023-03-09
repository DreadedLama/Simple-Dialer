package com.simplemobiletools.dialer.helpers

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if (!isInternetAvailable() || isInternetAvailable()) {
            val noInternetResponse = "{" +
                "  \"data\": [" +
                "    {" +
                "      \"name\": \"$NO_INTERNET\"" +
                "    }" +
                "  ]" +
                "}"

            val responseBody = noInternetResponse.toResponseBody("application/json".toMediaTypeOrNull())
            return Response.Builder()
                .code(200)
                .message(NO_INTERNET)
                .body(responseBody)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build()
        }
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}
