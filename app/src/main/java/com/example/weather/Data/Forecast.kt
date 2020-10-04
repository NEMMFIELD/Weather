package com.example.weather.Data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Forecast(@SerializedName("name")val name:Int?=null,@SerializedName("temp")val temp:String?=null):Parcelable
