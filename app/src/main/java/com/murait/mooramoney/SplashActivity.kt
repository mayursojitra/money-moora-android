package com.murait.mooramoney

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.murait.mooramoney.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SplashActivity, R.layout.activity_splash)


        binding.tvAppName.text =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                Html.fromHtml(
                    "Money <font color='#FF70A3'>Moora</font>",
                    Html.FROM_HTML_MODE_LEGACY
                ) else
                Html.fromHtml("Money <font color='#FF70A3'>Moora</font>")


        binding.btnStartNow.setOnClickListener {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}