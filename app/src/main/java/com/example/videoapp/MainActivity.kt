package com.example.videoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.videoapp.databinding.ActivityMainBinding
import com.example.videoapp.model.ChannelModel
import com.example.videoapp.model.ItemsItem
import com.example.videoapp.service.ApiConfig
import io.flutter.embedding.android.FlutterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchQuery: String

    companion object {
        private const val CHANNEL_ID = "UCbc1RY0McnikiEMD8Box5Ig"
        private const val API_KEY = "AIzaSyBUTZd79Ws9gNP3MBAIQgrtOsXVC3HrW9o"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadChannel()

        binding.btnSeePlaylist.setOnClickListener {
            startActivity(
                FlutterActivity.NewEngineIntentBuilder(FlutterApplication::class.java)
                    .build(this).putExtra("search", searchQuery)
            )
        }
    }

    private fun loadChannel() {
        showLoading(true)
        val client = ApiConfig.getApiService().getChannel(CHANNEL_ID, API_KEY)
        client.enqueue(object : Callback<ChannelModel> {
            override fun onResponse(
                call: Call<ChannelModel>,
                response: Response<ChannelModel>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        setRestaurantData(responseBody.items[0])
                    }
                } else {
                    Log.e("TAG", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ChannelModel>, t: Throwable) {
                showLoading(false)
                Log.e("TAG", "onFailure: ${t.message}")
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setRestaurantData(item: ItemsItem) {
        binding.tvChannelName.text = item.snippet.title
        searchQuery = "ruangguru"
        Glide.with(this@MainActivity)
            .load(item.snippet.thumbnails.medium.url)
            .into(binding.ivChannel)
    }
}