package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.CallModel

class CallListViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_item_call_list,
                parent,
                false
        )
) {


    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val txtDate: TextView
    private val txtTime: TextView
    private val imgCallIcon: ImageView


    init {
        imgProfile = itemView.findViewById<ImageView>(R.id.imgProfile)
        txtUserName = itemView.findViewById<TextView>(R.id.txtUserName)
        txtDate = itemView.findViewById<TextView>(R.id.txtDate)
        txtTime = itemView.findViewById<TextView>(R.id.txtTime)
        imgCallIcon = itemView.findViewById<ImageView>(R.id.imgCalllIcon)
    }

    fun bind(callModel: CallModel, onItemClickListener: (callModel: CallModel) -> Unit) {

        imgProfile.setBackgroundResource(callModel.profilePhoto)
        txtUserName.text = callModel.userName
        txtDate.text = callModel.date
        txtTime.text = callModel.time
        imgCallIcon.setBackgroundResource(callModel.callIcon)

        itemView.setOnClickListener { onItemClickListener(callModel) }
    }

}
