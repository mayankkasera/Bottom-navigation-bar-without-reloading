package com.mayank.test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank.test.R
import com.mayank.test.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var mBinding : FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFirstBinding.inflate(layoutInflater)
        return mBinding.root
    }

}