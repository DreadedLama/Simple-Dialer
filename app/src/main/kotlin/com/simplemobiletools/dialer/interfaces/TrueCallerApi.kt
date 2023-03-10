package com.simplemobiletools.dialer.interfaces


import com.simplemobiletools.dialer.helpers.ADVANCED_URL
import com.simplemobiletools.dialer.helpers.NetworkConnectionInterceptor
import com.simplemobiletools.dialer.models.truecaller.TrueCallerResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TrueCallerApi {

    @GET("search")
    suspend fun getTrueCallerResponse(
        @Query("countryCode") countryCode: String,
        @Query("q") mobileNumber: String,
        @Query("type") type: String,
        @Header("Authorization") authorizationToken: String
    ): Response<TrueCallerResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): TrueCallerApi {

            val okHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor).build()

            val retrofit =
                Retrofit.Builder()
                    .client(okHttpclient)
                    .baseUrl(ADVANCED_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(TrueCallerApi::class.java)
        }
    }
}
