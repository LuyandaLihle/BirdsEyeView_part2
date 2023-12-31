package com.example.birdseyeview_part2.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.birdseyeview_part2.R
import com.example.birdseyeview_part2.apiService.RetrofitInstance


class BirdsRepository {
    private var birdsMutableList: MutableLiveData<Birds> = MutableLiveData()

    suspend fun getMutableLiveData(query: String): MutableLiveData<Birds> {

        Log.d("API", "$query es la query")
        val call = RetrofitInstance().retrofitService.getBirdsNames(query)
        Log.d("API", "$call es la call")

        val birdsInfo = call.body()
        Log.d("API", "response: $birdsInfo")
        if (call.isSuccessful) {
            birdsMutableList.postValue(birdsInfo)

        }
        return birdsMutableList
    }
}
