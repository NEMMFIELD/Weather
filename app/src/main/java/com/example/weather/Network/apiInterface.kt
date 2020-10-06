package com.example.weather.Network

import com.example.weather.Data.Forecast
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiInterface {

    @GET("weather?appid=92756c24107bc39dd0a7541f66ba55c5&units=metric")
   suspend fun getWeatherMoscow(@Query("q") name: String?): Response<Forecast?>?
}