package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.StatusEntity

class StatusListAdapter(
        var statusList: List<StatusEntity>? = null,
        val onItemClickListener: (statusEntity: StatusEntity) -> Unit
) : RecyclerView.Adapter<StatusListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusListViewHolder =
            StatusListViewHolder(parent)

    override fun getItemCount(): Int {
        statusList?.let { _statusEntity ->
            return _statusEntity.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: StatusListViewHolder, position: Int) {
        statusList?.let { holder.bind(it[position], onItemClickListener) }
    }

    fun setNewItem(statusList: List<StatusEntity>) {
        this.statusList = statusList
        notifyDataSetChanged()
    }
}