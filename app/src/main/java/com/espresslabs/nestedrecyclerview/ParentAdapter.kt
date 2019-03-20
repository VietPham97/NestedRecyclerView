package com.espresslabs.nestedrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.main_feed.view.*

class ParentAdapter(private val parents : List<ParentModel>)
    : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_feed,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.title
        val childLayoutManager = LinearLayoutManager(
            holder.recyclerView.context,
            LinearLayout.HORIZONTAL,
            false
        )
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.children)
            setRecycledViewPool(viewPool)
        }
    }

    inner class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }
}

