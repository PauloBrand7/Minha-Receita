package br.com.minhareceita.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.minhareceita.R
import br.com.minhareceita.presentation.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}