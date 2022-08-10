package com.example.firebasepushnotifications.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firebasepushnotifications.page.NotificationsFragment
import com.example.firebasepushnotifications.page.ProfileFragment
import com.example.firebasepushnotifications.page.UsersFragment

/**
 * Created by Rick on 2022-08-10  15:18.
 * God bless my code!
 * @Description:主页Adapter
 */
class PagerViewAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayListOf(ProfileFragment(), UsersFragment(), NotificationsFragment())

    override fun getItemCount() = 3

    override fun createFragment(position: Int) = fragments[position]
}