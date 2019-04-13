package io.androidedu.hoop.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>, ViewPager.OnPageChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_camera)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_chat)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_hourglass_full)
        tabLayout.getTabAt(3)?.setIcon(R.drawable.ic_call)

        viewPager.currentItem = 1

        tabLayout.addOnTabSelectedListener(this)

        viewPager.addOnPageChangeListener(this)
    }


    override fun onTabReselected(p0: TabLayout.Tab?) {
        Log.v("TAG", "onTabReselected")
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        Log.v("TAG", "onTabUnselected")
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        Log.v("TAG", "onTabSelected")
    }

    override fun onPageScrollStateChanged(state: Int) {
        Log.v("TAG", "onPageScrollStateChanged")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.v("TAG", "onPageScrolled")
    }

    override fun onPageSelected(position: Int) {
        Log.v("TAG", "onPageSelected")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.settings_menu_item -> {
                Toast.makeText(this, "Clicked menu item : SETTINGS", Toast.LENGTH_SHORT).show()
            }
            R.id.search_menu_item -> {
                Toast.makeText(this, "Clicked menu item : SEARCH", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
