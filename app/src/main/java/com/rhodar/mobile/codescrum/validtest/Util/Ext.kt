package com.rhodar.mobile.codescrum.validtest.Util

import android.content.Context
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView

fun RecyclerView.addDivider(context: Context, orientation: Int) {
    val divider = DividerItemDecoration(context, orientation)
    this.addItemDecoration(divider)
}