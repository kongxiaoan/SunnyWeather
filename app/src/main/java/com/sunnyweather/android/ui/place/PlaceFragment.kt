package com.sunnyweather.android.ui.place

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunnyweather.android.R
import com.sunnyweather.android.TestLiveDataActivity
import com.sunnyweather.android.databinding.FragmentPlaceBinding
import kotlinx.android.synthetic.main.fragment_place.*


class PlaceFragment : Fragment() {
    private lateinit var binding: FragmentPlaceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentPlaceBinding.inflate(inflater,container,false)
        context ?: return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startLiveData.setOnClickListener {
            TestLiveDataActivity.startLiveData(requireContext())
        }
    }
}