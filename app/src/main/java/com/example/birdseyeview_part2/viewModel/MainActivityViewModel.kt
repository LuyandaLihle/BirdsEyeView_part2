package com.example.birdseyeview_part2.viewModel

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.birdseyeview_part2.model.BirdsRepository
import com.example.birdseyeview_part2.model.Bird
import com.example.birdseyeview_part2.model.Birds

class MainActivityViewModel: ViewModel() {

    private lateinit var birdsRepository: BirdsRepository



    @SuppressLint("NotConstructor")
    fun mainActivityViewModel(@NonNull application: Application) {
        birdsRepository = BirdsRepository()


    }

    suspend fun getAllBirds(query: String): MutableLiveData<Birds> {
        mainActivityViewModel(application = Application())
        return birdsRepository.getMutableLiveData(query)
    }


}