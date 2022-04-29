package com.inc.vr.corp.apps.rawgames.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.inc.vr.corp.apps.rawgames.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class SplashScreenActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}