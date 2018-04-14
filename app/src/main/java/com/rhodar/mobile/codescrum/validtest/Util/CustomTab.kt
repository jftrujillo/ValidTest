package com.rhodar.mobile.codescrum.validtest.Util

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.rhodar.mobile.codescrum.validtest.R


class CustomTab : TabLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun setupWithViewPager(viewPager: ViewPager?) {
        super.setupWithViewPager(viewPager)
        Log.i("TAG", "setupWithViewPager")
        if (viewPager!!.adapter == null) {
            return
        }
        createTabIcons()
    }

    private fun createTabIcons() {
        Log.i("TAG", "createTabIcons")
        val tabOne = LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as RelativeLayout
        (tabOne.findViewById<View>(R.id.text_title) as TextView).text = "tab 1"
        this.getTabAt(0)!!.customView = tabOne

        val tabTwo = LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as RelativeLayout
        (tabOne.findViewById<View>(R.id.text_title) as TextView).text = "tab 2"
        this.getTabAt(1)!!.customView = tabTwo

    }
}
