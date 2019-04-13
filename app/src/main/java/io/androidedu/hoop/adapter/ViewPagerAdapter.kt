package io.androidedu.hoop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.androidedu.hoop.ui.CallsFragment
import io.androidedu.hoop.ui.CameraFragment
import io.androidedu.hoop.ui.ChatsFragment
import io.androidedu.hoop.ui.StatusFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val chatsFragment by lazy { ChatsFragment.newInstance() }
    private val statusFragment by lazy { StatusFragment.newInstance() }
    private val cameraFragment by lazy { CameraFragment.newInstance() }
    private val callsFragment by lazy { CallsFragment.newInstance() }

    val fragmentList = ArrayList<Fragment>().apply {
        add(cameraFragment)
        add(chatsFragment)
        add(statusFragment)
        add(callsFragment)
    }

    val fragmentTitleList = ArrayList<String>().apply {
        add("Camera")
        add("Chats")
        add("Status")
        add("Calls")
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = fragmentTitleList[position]

}