package com.udacity.shoestore.custom.binding

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

@BindingAdapter("android:text")
fun EditText.bindDoubleToString(value: Double?) {
    value?.let {
        if (value == 0.0) {
            setText("")
        } else {
            setText(value.toString())
        }
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun EditText.getDoubleFromBinding(): Double? {
    val result=text.toString()

    return try {
        result.toDouble()
    }catch (e:Exception){
        0.0
    }
}