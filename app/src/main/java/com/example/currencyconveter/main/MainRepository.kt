package com.example.currencyconveter.main

import com.example.currencyconveter.data.models.NewCurrencyResponse
import com.example.currencyconveter.util.Resource

interface MainRepository {

    suspend fun getRates(base: String) : Resource<NewCurrencyResponse>

}