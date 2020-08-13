package com.bokerou.garbagecollection.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bokerou.garbagecollection.GarbageCollectionApplication
import com.bokerou.garbagecollection.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val garbages = mutableListOf(Garbage("可回收物", R.drawable.recyclable),
                                 Garbage("有害垃圾", R.drawable.hazardous_waste),
                                 Garbage("厨余垃圾", R.drawable.food_waste),
                                 Garbage("其他垃圾", R.drawable.residual_waste)
    )

    val garbageList = ArrayList<Garbage>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initGarbage()
        val layoutManager = GridLayoutManager(GarbageCollectionApplication.context, 1)
        homeRecyclerView.layoutManager = layoutManager
        val adapter = GarbageAdapter(GarbageCollectionApplication.context, garbageList)
        homeRecyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val garbageView: View = inflater.inflate(R.layout.fragment_home, container, false)

        return garbageView
    }
    private fun initGarbage() {
        garbageList.clear()
        garbageList.add(garbages[0])
        garbageList.add(garbages[1])
        garbageList.add(garbages[2])
        garbageList.add(garbages[3])

    }
}