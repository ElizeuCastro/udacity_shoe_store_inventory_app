package com.udacity.shoestore.custom.view

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.databinding.FragmentListItemBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_list_item.view.*

class ShoeItemView(
    context: Context,
    shoe: Shoe
) : ConstraintLayout(context) {

    init {

        FragmentListItemBinding.inflate(LayoutInflater.from(context), this, true).apply {
            name_text.text = shoe.name
            size_text.text = shoe.size.toString()
            description_text.text = shoe.description
            company_text.text = shoe.company
        }


    }
}