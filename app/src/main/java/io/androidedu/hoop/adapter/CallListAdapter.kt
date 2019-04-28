package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.CallEntity

class CallListAdapter(
        var callList: List<CallEntity>? = null,
        val onItemClickListener: (callEntity: CallEntity) -> Unit
) : RecyclerView.Adapter<CallListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListViewHolder = CallListViewHolder(parent)

    override fun getItemCount(): Int {
        callList?.let { _callentity ->
            return _callentity.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: CallListViewHolder, position: Int) {
        callList?.let { holder.bind(it[position], onItemClickListener) }
    }

    fun setNewItem(callList: List<CallEntity>) {
        this.callList = callList
        notifyDataSetChanged()
    }
}
