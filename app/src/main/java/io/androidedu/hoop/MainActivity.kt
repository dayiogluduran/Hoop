package io.androidedu.hoop

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(CameraFragment())

        calls_button.setOnClickListener(this)
        status_button.setOnClickListener(this)
        chats_button.setOnClickListener(this)
        camera_image.setOnClickListener(this)

    }

    override fun onClick(item: View?) {
        when (item?.id) {
            R.id.calls_button -> {
                changeFragment(CallsFragment())
            }
            R.id.status_button -> {
                changeFragment(StatusFragment())
            }
            R.id.chats_button -> {
                changeFragment(ChatsFragment())
            }
            R.id.camera_image -> {
                changeFragment(CameraFragment())
            }
        }
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.search_menu_item -> {
                Toast.makeText(this, "Clicked menu item : SEARCH", Toast.LENGTH_SHORT).show()
            }
            R.id.settings_menu_item -> {
                Toast.makeText(this, "Clicked menu item : SETTINGS", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

