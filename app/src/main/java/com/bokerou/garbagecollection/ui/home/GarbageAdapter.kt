package com.bokerou.garbagecollection.ui.home

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokerou.garbagecollection.GarbageCollectionApplication
import com.bokerou.garbagecollection.R
import com.bumptech.glide.Glide

class GarbageAdapter (val context: Context, val garbageList: List<Garbage>) :
        RecyclerView.Adapter<GarbageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val garbageCategoryImage: ImageView = view.findViewById(R.id.garbageCategoryImage)
        val garbageCategoryType: TextView = view.findViewById(R.id.garbageCategoryType)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GarbageAdapter.ViewHolder {
        val view = LayoutInflater.from(GarbageCollectionApplication.context).inflate(R.layout.home_garbage_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() =garbageList.size

    override fun onBindViewHolder(holder: GarbageAdapter.ViewHolder, position: Int) {
        val garbage = garbageList[position]
        holder.garbageCategoryType.text = garbage.type
        holder.garbageCategoryImage.setImageResource(garbage.imageId)
    }

}