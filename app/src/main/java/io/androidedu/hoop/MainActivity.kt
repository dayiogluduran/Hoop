package io.androidedu.hoop

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.main_fragment, CameraFragment()).commit()

        calls_button.setOnClickListener(this)
        status_button.setOnClickListener(this)
        chats_button.setOnClickListener(this)
        camera_image.setOnClickListener(this)

    }

    override fun onClick(item: View?) {

        supportFragmentManager.beginTransaction().apply {
            when (item?.id) {
                R.id.calls_button -> {
                    replace(R.id.main_fragment, CallsFragment())
                }
                R.id.status_button -> {
                    replace(R.id.main_fragment, StatusFragment())
                }
                R.id.chats_button -> {
                    replace(R.id.main_fragment, ChatsFragment())
                }
                R.id.camera_image -> {
                    replace(R.id.main_fragment, CameraFragment())
                }
                else -> {
                }
            }
        }.commit()
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

