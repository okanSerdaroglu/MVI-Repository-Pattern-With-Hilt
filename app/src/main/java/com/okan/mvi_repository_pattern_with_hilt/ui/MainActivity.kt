package com.okan.mvi_repository_pattern_with_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okan.mvi_repository_pattern_with_hilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}