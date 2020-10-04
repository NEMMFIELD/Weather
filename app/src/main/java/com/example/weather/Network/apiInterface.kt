package com.example.weather.Network

import com.example.weather.Data.Forecast
import retrofit2.Response
import retrofit2.http.GET

interface apiInterface {

    @GET("api.openweathermap.org/data/2.5/weather?q=Moscow&appid=ee14dbc8d2b2885487c2bfe9f5745acb")
    suspend fun getWeatherMoscow(): Response<Forecast>
}