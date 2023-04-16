package com.example.currencyconveter.main

import com.example.currencyconveter.data.api.CurrencyApi
import com.example.currencyconveter.data.models.NewCurrencyResponse
import com.example.currencyconveter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository{

    override suspend fun getRates(base: String): Resource<NewCurrencyResponse> {

        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) Resource.Success(result)
            else Resource.Error(response.message())
        } catch (e: Exception){
            Resource.Error(e.message ?: "An error occurred")
        }

    }


}