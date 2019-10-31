package com.mhmdreza.azmoonyar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhmdreza.azmoonyar.base.BaseFragment
import com.mhmdreza.azmoonyar.views.SplashFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        startFragment(SplashFragment())
    }

    fun startFragment(fragment: BaseFragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFragment, fragment)
        fragmentTransaction.commit()
    }
}
