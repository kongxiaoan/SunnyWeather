package com.sunnyweather.android.ui.pisture

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sunnyweather.android.R
import com.sunnyweather.android.databinding.FragmentPictureBinding
import com.sunnyweather.android.logic.model.PictureViewModel
import com.sunnyweather.android.utils.InjectorUtils

/**
 * A simple [Fragment] subclass.
 * Use the [PictureFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PictureFragment : Fragment() {
    //    private lateinit var viewModel: PictureViewModel
    private lateinit var binding: FragmentPictureBinding
    private val viewModel: PictureViewModel by viewModels {
        InjectorUtils.providerPictureViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPictureBinding.inflate(inflater, container, false)
        context ?: return binding.root
        return inflater.inflate(R.layout.fragment_picture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(PictureViewModel::class.java)
        viewModel.pictureBitmap.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, "bitmap size is ${it.allocationByteCount}" )
            binding.pictureIV.setImageBitmap(it)
        })
    }

    companion object{
        const val TAG = "PictureFragment"
    }
}