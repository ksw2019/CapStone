package com.example.capstone_projects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.capstone_projects.databinding.FragmentPageBinding

private const val TAG_HOSPITIAL = "hosipital_map"
private const val TAG_HOME = "main_page"
private const val TAG_HEAL = "healthheal_page"
class NaviActivity : AppCompatActivity() {

    private lateinit var binding: FragmentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.NavigationView.setOnItemSelectedListener { item->
            when(item.itemId) {
                R.id.mapfragment -> setFragment(TAG_HOSPITIAL, HosipitalFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.healFragment -> setFragment(TAG_HEAL, HealFragment())
                }
            true
            }
        }
    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.fragmentContainer, fragment, tag)
        }

        val hosipital = manager.findFragmentByTag(TAG_HOSPITIAL)
        val home = manager.findFragmentByTag(TAG_HOME)
        val heal = manager.findFragmentByTag(TAG_HEAL)

        if (hosipital != null){
            fragTransaction.hide(hosipital)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (heal != null) {
            fragTransaction.hide(heal)
        }

        if (tag == TAG_HOSPITIAL) {
            if (hosipital!=null){
                fragTransaction.show(hosipital)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_HEAL){
            if (heal != null){
                fragTransaction.show(heal)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}

