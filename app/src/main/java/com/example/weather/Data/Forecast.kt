package com.example.weather.Data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Forecast(@SerializedName("name")val name:String?=null,@SerializedName("main")val main:Main?=null)
