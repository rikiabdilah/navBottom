package com.example.navbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navbottom.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragmentt(FragmentNav())
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> loadFragmentt(FragmentNav())
                R.id.message -> loadFragmentt(FragmentMessage())
                R.id.settings -> loadFragmentt(FragmentSetting())
            }
            true
        }
    }

    private fun loadFragmentt(fragment:Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}