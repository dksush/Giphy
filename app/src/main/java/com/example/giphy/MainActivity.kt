package com.example.giphy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.giphy.databinding.ActivityMainBinding
import com.example.giphy.ui.favorite.FavoriteFragment
import com.example.giphy.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pagerAdapter = PagerAdapter(this)
    private val fm = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            navigationItemSelectedListener
        )

        binding.viewPager.run {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigation.menu.getItem(position).isChecked = true
                }
            })
        }


        //val fragmentTransaction = supportFragmentManager.beginTransaction()
        //fragmentTransaction.add(R.id.con_test, HomeFragment.newInstance()).commit()
    }

    fun replaceFragment(fragment: Fragment?) {
        fragment?.let {
            fm.replace(R.id.con_test, it).addToBackStack(null).commit()
        }
    }

    private val navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_movie -> {
                    setPageWithIndex(0)
                    true
                }
                R.id.menu_image -> {
                    setPageWithIndex(1)
                    true
                }
                else -> {
                    false
                }
            }
        }

    private fun setPageWithIndex(index: Int) {
        binding.viewPager.currentItem = index
    }

    inner class PagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {

        private val fragmentList =
            listOf(SearchFragment(), FavoriteFragment())

        override fun getItemCount() = fragmentList.size
        override fun createFragment(position: Int) = fragmentList[position] as Fragment
    }
}
