package com.example.finaluirs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finaluirs.databinding.ActivityMainBinding
import com.example.finaluirs.fragments.AnalyticsFragment
import com.example.finaluirs.fragments.ExploreFragment
import com.example.finaluirs.fragments.HomeFragment
import com.example.finaluirs.fragments.PersonFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val analyticsFragment = AnalyticsFragment()
        val personFragment = PersonFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_analytics -> makeCurrentFragment(analyticsFragment)
                R.id.ic_explore -> makeCurrentFragment(exploreFragment)
                R.id.ic_person -> makeCurrentFragment(personFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}