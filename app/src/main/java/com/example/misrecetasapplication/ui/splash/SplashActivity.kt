package com.example.misrecetasapplication.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.misrecetasapplication.ActivityBase
import com.example.misrecetasapplication.databinding.ActivitySplashBinding
import com.example.misrecetasapplication.ui.DetailScreenActivity.DetailScreenActivity
import com.example.misrecetasapplication.ui.main.HomeScreenActivity
import com.example.misrecetasapplication.utils.Utils

class SplashActivity : ActivityBase() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            finish()
            startActivity(Intent(this@SplashActivity, HomeScreenActivity::class.java))
        }, 1500)

    }
}