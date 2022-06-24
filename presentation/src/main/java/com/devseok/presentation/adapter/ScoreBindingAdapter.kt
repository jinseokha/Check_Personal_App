package com.devseok.presentation.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */
object ScoreBindingAdapter {

    @JvmStatic
    @BindingAdapter("set_man")
    fun setMan(text : TextView, name : String) {
        text.text = name
    }

    @JvmStatic
    @BindingAdapter("set_woman")
    fun setWoman(text : TextView, name : String) {
        text.text = name
    }

    @JvmStatic
    @BindingAdapter("set_percentage")
    fun setPercentage(text : TextView, content : Int) {
        text.text = content.toString()
    }
}