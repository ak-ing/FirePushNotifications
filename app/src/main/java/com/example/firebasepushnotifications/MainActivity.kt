package com.example.firebasepushnotifications

import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.firebasepushnotifications.adapter.PagerViewAdapter
import com.example.firebasepushnotifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mPagerViewAdapter: PagerViewAdapter
    private lateinit var tabs: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        mPagerViewAdapter = PagerViewAdapter(this)
        with(mBinding) {
            tabs = arrayListOf(profileLabel, userLabel, notificationsLabel)
            mainPager.adapter = mPagerViewAdapter
            mainPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    changeTabs(position)
                }
            })
            profileLabel.setOnClickListener { mainPager.currentItem = 0 }
            userLabel.setOnClickListener { mainPager.currentItem = 1 }
            notificationsLabel.setOnClickListener { mainPager.currentItem = 2 }
        }
    }

    /**
     * 切换选项卡
     */
    private fun changeTabs(position: Int) {
        for (i in 0 until 3) {
            if (i == position) {
                tabs[i].setTextColor(getColor(R.color.textTabBright))
                tabs[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            } else {
                tabs[i].setTextColor(getColor(R.color.textTabNight))
                tabs[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            }
        }
    }

}