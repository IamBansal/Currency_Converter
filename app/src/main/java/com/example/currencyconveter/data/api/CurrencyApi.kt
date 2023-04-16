package com.example.currencyconveter.data.api

import com.example.currencyconveter.data.models.NewCurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApi {

    @GET("latest/{base}")
    suspend fun getRates(@Path(value = "base") base: String) : Response<NewCurrencyResponse>
}