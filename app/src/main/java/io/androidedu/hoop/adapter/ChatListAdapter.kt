package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.ChatEntity

class ChatListAdapter(var chatList: List<ChatEntity>? = null,
                      val onItemClickListener: (chatEntity: ChatEntity) -> Unit) : RecyclerView.Adapter<ChatListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder = ChatListViewHolder(parent)

    override fun getItemCount(): Int {
        chatList?.let { _chatEntity ->
            return _chatEntity.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        chatList?.let { holder.bind(it[position], onItemClickListener) }
    }

    fun setNewItem(chatList: List<ChatEntity>) {
        this.chatList = chatList
        notifyDataSetChanged()
    }
}