package com.bokerou.garbagecollection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bokerou.garbagecollection.ui.home.HomeFragment
import com.bokerou.garbagecollection.ui.mine.MineFragment
import com.bokerou.garbagecollection.ui.nearby.NearbyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMain()
        home_button.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_body, HomeFragment())
            transaction.commit()
            setSelectStatus(0)
        }
        nearby_button.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_body, NearbyFragment())
            transaction.commit()
            setSelectStatus(1)
        }
        mine_button.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_body, MineFragment())
            transaction.commit()
            setSelectStatus(2)
        }
    }

    private fun setSelectStatus(index: Int) {

        val homeButton: TextView = home_button
        val nearbyButton: TextView= nearby_button
        val mineButton: TextView = mine_button

        when(index) {
            0 -> {
                homeButton.setTextColor(Color.parseColor("#99FF99"))
                nearbyButton.setTextColor(Color.parseColor("#000000"))
                mineButton.setTextColor(Color.parseColor("#000000"))
            }
            1 -> {
                nearbyButton.setTextColor(Color.parseColor("#99FF99"))
                homeButton.setTextColor(Color.parseColor("#000000"))
                mineButton.setTextColor(Color.parseColor("#000000"))
            }
            2 -> {
                mineButton.setTextColor(Color.parseColor("#99FF99"))
                homeButton.setTextColor(Color.parseColor("#000000"))
                nearbyButton.setTextColor(Color.parseColor("#000000"))
            }
        }
    }

    private fun setMain() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.main_body, HomeFragment()).commit()
        setSelectStatus(0)
    }


}