package com.harjot.servicepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.harjot.servicepractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Start.setOnClickListener {
            val input: String = binding.editText.text.toString()
            val serviceIntent = Intent(this, nService::class.java)
            serviceIntent.putExtra("inputExtra", input)
            ContextCompat.startForegroundService(this, serviceIntent)
        }
        binding.Stop.setOnClickListener {
            val serviceIntent = Intent(this, nService::class.java)
            stopService(serviceIntent)
        }
    }
}