package com.w4eret1ckrtb1tch.focusstart.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.w4eret1ckrtb1tch.focusstart.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}