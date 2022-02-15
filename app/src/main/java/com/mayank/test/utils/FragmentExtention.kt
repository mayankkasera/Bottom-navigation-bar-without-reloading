package com.mayank.test.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mayank.test.R

fun List<Fragment>.addAndHide(fragmentManager : FragmentManager, @IdRes containerViewId : Int){
    if(this.isNotEmpty()){
        this.forEachIndexed  { index, element ->
            fragmentManager.beginTransaction().add(containerViewId, element, "$index").hide(element).commit()
        }
        fragmentManager.beginTransaction().addToBackStack("First").show(this[0]).commit()
    }
}