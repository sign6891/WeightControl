package ru.sign6891.weightcontrol.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.sign6891.weightcontrol.R
import ru.sign6891.weightcontrol.data.source.local.entity.DataElementEntity

class ElementListAdapter : ListAdapter<DataElementEntity, ElementListAdapter.ElementViewHolder>(ElementComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        return ElementViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.time, current.weight)

    }


    class ElementViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        private val dataTV: TextView = itemView.findViewById(R.id.textViewData)
        private val weightTV: TextView = itemView.findViewById(R.id.textViewWeight)

        fun bind(data: String?, weight: String?) {
            dataTV.text = data
            weightTV.text = weight
        }

        companion object {
            fun create(parent:ViewGroup) : ElementViewHolder {
                val view:View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_data, parent, false)
                return ElementViewHolder(view)
            }
        }
    }

    class ElementComparator : DiffUtil.ItemCallback<DataElementEntity>() {
        override fun areItemsTheSame(oldItem: DataElementEntity, newItem: DataElementEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataElementEntity, newItem: DataElementEntity): Boolean {
            return oldItem.weight == newItem.weight
        }

    }
}


