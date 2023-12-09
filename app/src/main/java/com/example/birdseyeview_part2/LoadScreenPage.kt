package com.example.birdseyeview_part2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.birdseyeview_part2.databinding.ActivityLoadscreenBinding
import com.example.birdseyeview_part2.userInterface.SearchPage

class LoadScreenPage : AppCompatActivity () {
    private lateinit var binding: ActivityLoadscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.birdButton.setOnClickListener {
            val intent = Intent(this, ExploreBirdsPage::class.java)
            startActivity(intent)
        }
        binding.mapButton.setOnClickListener {
            val intent = Intent(this, MapPage::class.java)
            startActivity(intent)
        }
        binding.searchButton.setOnClickListener {
            val intent = Intent(this, SearchPage::class.java)
            startActivity(intent)
        }
    }

}