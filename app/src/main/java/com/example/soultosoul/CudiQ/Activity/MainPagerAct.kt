package com.example.soultosoul.CudiQ.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.soultosoul.CudiQ.Fragments.MainFragments.CallFragment
import com.example.soultosoul.CudiQ.Fragments.MainFragments.MainPageFragment
import com.example.soultosoul.CudiQ.Fragments.MainFragments.MessageFragment
import com.example.soultosoul.CudiQ.Fragments.MainFragments.ProfileFragment
import com.example.soultosoul.CudiQ.viewmodels.MainViewModel
import com.example.soultosoul.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_pager.*

class MainPagerAct : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var current: Fragment = MainPageFragment()
    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pager)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initClickersOfBotNav()
    }

    private fun initClickersOfBotNav() {
        bottomNavBar.setOnNavigationItemSelectedListener(this)
        bottomNavBar.selectedItemId = R.id.ic_home
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.ic_home -> {
                if (current != MainPageFragment()) {
                    current = MainPageFragment()
                    gotoFragment(MainPageFragment())
                    return true

                }
            }
            R.id.ic_call -> {
                if (current != CallFragment()) {
                    current = CallFragment()
                    gotoFragment(CallFragment())
                    return true
                }
            }
            R.id.ic_message -> {
                if (current != MessageFragment()) {
                    current = MessageFragment()
                    gotoFragment(MessageFragment())
                    return true
                }
            }
            R.id.ic_person -> {
                if (current != ProfileFragment()) {
                    current = ProfileFragment()
                    gotoFragment(ProfileFragment())
                    return true
                }
            }
            else -> {
                return false
            }
        }
        return false
    }

    private fun gotoFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    fun navBarGONE() {
        bottomNavBar.visibility = View.GONE
        bottomNavBar.isClickable = false
    }

    fun navBarVisible() {
        bottomNavBar.visibility = View.VISIBLE
        bottomNavBar.isClickable = true
    }

}