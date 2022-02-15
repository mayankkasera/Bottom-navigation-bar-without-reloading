package com.mayank.test


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mayank.test.databinding.ActivityMainBinding
import com.mayank.test.fragment.FirstFragment
import com.mayank.test.fragment.SecondFragment
import com.mayank.test.fragment.ThirdFragment
import com.mayank.test.utils.addAndHide


private const val TAG = "123MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var fragmentManager : FragmentManager

    private val list = listOf<Fragment>(FirstFragment(),SecondFragment(),ThirdFragment())
    private var activeFragment = list[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager
        list.addAndHide(fragmentManager,R.id.frame)

        binding.bnvMain.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.first -> {
                    fragmentManager.beginTransaction().addToBackStack("First").hide(activeFragment).show(list[0]).commit()
                    activeFragment = list[0]
                }
                R.id.second ->{
                    fragmentManager.beginTransaction().addToBackStack("Second").hide(activeFragment).show(list[1]).commit()
                    activeFragment = list[1]
                }
                R.id.third -> {
                    fragmentManager.beginTransaction().addToBackStack("Third").hide(activeFragment).show(list[2]).commit()
                    activeFragment = list[2]
                }
            }
            true
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        if ((fragmentManager.backStackEntryCount - 1) >= 0) {
           val lastBackStackEntry = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1)
            Log.i(TAG, "onCreate: ${lastBackStackEntry.name}")
            when(lastBackStackEntry.name){
                "First" -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(list[0]).commit()
                    binding.bnvMain.menu.findItem(R.id.first).isChecked = true
                    activeFragment = list[0]
                }
                "Second" ->{
                    fragmentManager.beginTransaction().hide(activeFragment).show(list[1]).commit()
                    binding.bnvMain.menu.findItem(R.id.second).isChecked = true
                    activeFragment = list[1]
                }
                "Third" -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(list[2]).commit()
                    binding.bnvMain.menu.findItem(R.id.third).isChecked = true
                    activeFragment = list[2]
                }
            }
        }
        else{
           finish()
        }
    }


}