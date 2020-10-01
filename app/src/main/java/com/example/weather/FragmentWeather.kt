package com.example.weather

import android.content.ClipDescription
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_weather.*


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
        postToList()
        rv_recycler.layoutManager=LinearLayoutManager(this.context)
        rv_recycler.adapter=RecyclerAdapter(titleList,descList,imgList)
    }

    private fun addToList(title:String,description: String,image:Int)
    {
        titleList.add(title)
        descList.add(description)
        imgList.add(image)
    }

    private fun postToList()
    {
        for (i in 1..25)
        {
            addToList("Title $i","Description $i",R.mipmap.ic_launcher_round)
        }
    }




}