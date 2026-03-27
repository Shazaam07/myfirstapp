package com.dev.hellloji // Yahan bhi apna package name hi rakhna!

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Apne remote ko dhundho
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // 2. Jaise hi TV on ho, sabse pehle "Home" channel laga do
        replaceFragment(HomeFragment())
        bottomNav.selectedItemId = R.id.nav_home

        // 3. Remote ke button dabne ka wait karo
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_wallet -> replaceFragment(WalletFragment())
                R.id.nav_ranking -> replaceFragment(RankingFragment())
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            true // Iska matlab humne button click successully handle kar liya
        }
    }

    // 4. Yeh ek chhota sa helper function hai jo purane channel ko nikal kar naya channel lagata hai
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}