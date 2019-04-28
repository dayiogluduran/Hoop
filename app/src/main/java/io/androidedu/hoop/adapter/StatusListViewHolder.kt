package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.entity.StatusEntity

class StatusListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_item_status_list,
                parent,
                false
        )
) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView
    private val txtTime: TextView


    init {
        imgProfile = itemView.findViewById<ImageView>(R.id.imgProfile)
        txtUserName = itemView.findViewById<TextView>(R.id.txtUserName)
        txtDate = itemView.findViewById<TextView>(R.id.txtDate)
        txtTime = itemView.findViewById<TextView>(R.id.txtTime)
    }

    fun bind(statusEntity: StatusEntity, onItemClickListener: (statusEntity: StatusEntity) -> Unit) {

        imgProfile.setBackgroundResource(statusEntity.profilePhoto)
        txtUserName.text = statusEntity.userName
        txtDate.text = statusEntity.statusDate
        txtTime.text = statusEntity.statusTime

        itemView.setOnClickListener { onItemClickListener(statusEntity) }
    }

}
