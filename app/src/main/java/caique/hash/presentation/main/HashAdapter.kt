package caique.hash.presentation.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import caique.hash.R

/**
 * Created by Kanda on 11/06/2017.
 */
class HashAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_layout, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
            it.isClickable = false
        }
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}