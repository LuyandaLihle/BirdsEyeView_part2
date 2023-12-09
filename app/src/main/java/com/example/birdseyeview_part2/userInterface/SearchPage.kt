package com.example.birdseyeview_part2.userInterface

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.birdseyeview_part2.model.Bird
import com.example.birdseyeview_part2.databinding.ActivitySearchBinding
import com.example.birdseyeview_part2.model.Birds
import com.example.birdseyeview_part2.viewModel.BirdsAdapter
import com.example.birdseyeview_part2.viewModel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchPage : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val mAdapter: BirdsAdapter = BirdsAdapter()
    private lateinit var mRecyclerView: RecyclerView
    private var birdsList: List<Bird> ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                getBirds()


            }


        }
    }



    private suspend fun getBirds() {
        val mainActivityViewModel: MainActivityViewModel = ViewModelProvider(this).
        get(MainActivityViewModel::class.java)




        val precall = mainActivityViewModel.getAllBirds(binding.tiCountry.text.toString())
        runOnUiThread {
            precall.observe(this@SearchPage) {
                birdsList = it.birds

            }
            setUpRecyclerView()
            mAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView() {
        mRecyclerView = binding.rvBirds
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        birdsList?.let { mAdapter.birdsRecyclerAdapter(it, this) }
        binding.rvBirds.adapter = mAdapter


    }
}