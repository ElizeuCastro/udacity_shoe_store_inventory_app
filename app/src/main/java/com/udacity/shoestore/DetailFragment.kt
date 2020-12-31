package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        binding.viewModel = viewModel

        viewModel.cancelEvent.observe(viewLifecycleOwner, Observer { cancel ->
            if (cancel) {
                openListScreen()
                viewModel.onCancelComplete()
            }
        })

        viewModel.saveEvent.observe(viewLifecycleOwner, Observer { save ->
            if (save) {
                openListScreen()
                viewModel.onSaveComplete()
            }
        })

        return binding.root
    }

    private fun openListScreen() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
    }
}