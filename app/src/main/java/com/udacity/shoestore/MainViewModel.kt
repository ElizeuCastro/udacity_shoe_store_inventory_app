package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    var newShoe: Shoe = Shoe("", 0.0, "", "", emptyList())

    private var _cancelEvent = MutableLiveData<Boolean>()
    val cancelEvent: LiveData<Boolean>
        get() = _cancelEvent

    private var _saveEvent = MutableLiveData<Boolean>()
    val saveEvent: LiveData<Boolean>
        get() = _saveEvent

    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = initShoesList()
    }

    private fun initShoesList(): MutableList<Shoe> {
        return mutableListOf(
            Shoe(
                "Nike Air Force",
                42.0,
                "Nike",
                "Nike shoe",
                mutableListOf("https://rb.gy/k0rkac")
            ),
            Shoe(
                "Nike MD Runner 2 Suede",
                42.0,
                "Nike",
                "Nike shoe",
                mutableListOf("https://rb.gy/aisprb")
            )
        )
    }

    fun onCancel() {
        _cancelEvent.value = true
    }

    fun onSave() {
        _shoes.value?.add (0, newShoe)
        _saveEvent.value = true
    }

    fun onCancelComplete() {
        _cancelEvent.value = false
        resetNewShoe()
    }

    fun onSaveComplete() {
        _saveEvent.value = false
        resetNewShoe()
    }

    private fun resetNewShoe() {
        newShoe = Shoe("", 0.0, "", "", emptyList())
    }
}