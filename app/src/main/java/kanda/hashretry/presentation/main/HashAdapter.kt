package kanda.hashretry.presentation.main


import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import caique.hash.presentation.main.ViewHolder
import kanda.hashretry.R
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by Kanda on 11/06/2017.
 */
class HashAdapter(var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ViewHolder>() {
    var drawable: Int = R.drawable.ic_comp_menor
    var position: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_layout, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
            holder.itemView.isClickable = false
            holder.itemView.imageview1.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context, drawable))
        }
        if (this.position == position) {
           // onItemClickListener.onItemClick(position)
            holder.itemView.isClickable = false
            holder.itemView.imageview1.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_comp_menor))
        }

    }

    override fun getItemCount(): Int {
        return 9
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun robotItem(position: Int) {
        this.position = position
        notifyItemChanged(position)
    }
}