package com.example.tarsaidzezatiashvili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tarsaidzezatiashvili.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class space : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space)


        bottomNavigation = findViewById(R.id.bottom_navigation)
        fragmentManager = supportFragmentManager

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> {
                    val fragment = ProfileFragment()
                    openFragment(fragment)
                    true
                }
                R.id.balance -> {
                    val fragment = BalanceFragment()
                    openFragment(fragment)
                    true
                }
                R.id.other -> {
                    val fragment = OtherFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        // Set default selected fragment
        bottomNavigation.selectedItemId = R.id.profile
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}
