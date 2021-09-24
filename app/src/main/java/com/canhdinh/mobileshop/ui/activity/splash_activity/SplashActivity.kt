package com.canhdinh.mobileshop.ui.activity.splash_activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.base.BaseActivity
import com.canhdinh.mobileshop.ui.activity.main_activity.MainActivity
import com.canhdinh.mobileshop.util.LoadingScreen
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        checkConnection()
    }

    private fun checkConnection() {
        LoadingScreen.hideLoading()
        if (isOnline(this)) {
            Handler(Looper.getMainLooper()).postDelayed({
               startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 1000L)
        } else {
            val parentLayout = findViewById<View>(android.R.id.content)
            val snackbar =
                Snackbar.make(parentLayout, "No internet connection.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("RETRY") {
                      val  timer = object : android.os.CountDownTimer(5000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                LoadingScreen.displayLoadingWithText(
                                    this@SplashActivity,
                                    "Please wait...",
                                    false
                                )
                                val wifiManager =
                                    applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                                wifiManager.isWifiEnabled = true
                            }

                            override fun onFinish() {
                                LoadingScreen.hideLoading()
                                checkConnection()
                            }
                        }
                        (timer as CountDownTimer).start()
                    }
                    .setActionTextColor(Color.parseColor("#4AA5FE"))
                    .setTextColor(Color.parseColor("#F40707"))
            snackbar.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}