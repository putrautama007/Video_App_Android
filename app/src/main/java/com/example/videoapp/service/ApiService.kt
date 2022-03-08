package com.example.videoapp.service

import com.example.videoapp.model.ChannelModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("channels?part=snippet%2CcontentDetails%2Cstatistics")
    fun getChannel(
        @Query("id") id: String,
        @Query("key") key: String
    ): Call<ChannelModel>
}