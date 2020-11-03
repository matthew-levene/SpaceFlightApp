package com.ml.spaceflightapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ml.spaceflightapp.R
import com.ml.spaceflightapp.view.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_frame, HomeFragment())
            .commit()
    }
}