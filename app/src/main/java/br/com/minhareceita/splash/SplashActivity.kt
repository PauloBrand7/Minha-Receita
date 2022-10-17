package br.com.minhareceita.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.minhareceita.category.presentation.activity.MealCategoryActivity
import br.com.minhareceita.databinding.SplashScreenBinding

class SplashActivity: AppCompatActivity() {

    private lateinit var binding: SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this, MealCategoryActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}