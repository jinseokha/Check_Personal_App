package com.devseok.presentation.widget.extension

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */

fun RecyclerView.showVertical(context : Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}