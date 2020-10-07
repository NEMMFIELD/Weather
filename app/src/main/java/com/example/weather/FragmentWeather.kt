package com.example.weather

import android.content.ClipDescription
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.Network.Retrofit
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class FragmentWeather : Fragment() {

    private var titleList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imgList= mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_weather, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadWeather("Moscow")
        loadWeather("London")
        loadWeather("Berlin")


    }

    private fun loadWeather(str:String)
    {
        GlobalScope.launch(Dispatchers.Main)
        {
            try {
                val response = Retrofit().api.getWeatherMoscow(str)
                if (response?.isSuccessful!!) {
                    titleList.add(response.body()?.name.toString())
                    descList.add(response.body()?.main?.temp.toString())
                    imgList.add(R.mipmap.ic_launcher_round)
                    rv_recycler.layoutManager=LinearLayoutManager(context)
                    rv_recycler.adapter=RecyclerAdapter(titleList,descList,imgList)
                }

            } catch (e: Exception) {
                Toast.makeText(context, "Seems like error", Toast.LENGTH_SHORT).show()
                Log.d("error",e.toString())
            }
        }
    }



}