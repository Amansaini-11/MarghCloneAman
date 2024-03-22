package com.example.marghcloneaman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val FramContainer = findViewById<FrameLayout>(R.id.FrameContainer)

        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        BottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.buttomHome -> {
                    // Handle home navigation
                    replaceFragment(HomescreenFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.buttomsaved -> {
                    // Handle dashboard navigation
                    replaceFragment(SavedFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.buttomprofile -> {
                    // Handle notifications navigation
                    replaceFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

        replaceFragment(HomescreenFragment())

    }



    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.FrameContainer, fragment).commit()
    }
}