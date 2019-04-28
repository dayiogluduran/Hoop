package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.dao.ChatDao
import io.androidedu.hoop.db.HoopDb
import io.androidedu.hoop.entity.ChatEntity
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread

class ChatsFragment : Fragment() {

    private val hoopDb: HoopDb? by lazy { HoopDb.getInstance(context!!) }
    private val chatDao: ChatDao? by lazy { hoopDb?.getChatDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chatEntity = ChatEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "Duran Chat",
                userMessage = "Naber?",
                date = "14:00"
        )

        val chatEntity2 = ChatEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "İlknur Chat",
                userMessage = "Nerdesin?",
                date = "14:00"
        )
        val chatEntity3 = ChatEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "Dilek Chat",
                userMessage = "Naaaabeeeer?",
                date = "16:00"
        )

        val chatEntity4 = ChatEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "Gökhan Chat",
                userMessage = "Araba bozuldu",
                date = "14:00"
        )

        thread(start = true) {
            chatDao?.addNewChat(chatEntity)
            chatDao?.addNewChat(chatEntity2)
            chatDao?.addNewChat(chatEntity3)
            chatDao?.addNewChat(chatEntity4)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recycChatList) {
            adapter = ChatListAdapter { _chatEntity ->
                thread(start = true) {
                    chatDao?.deleteChat(_chatEntity)
                }
            }
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        }

        chatDao?.getAllChats()?.observe(this, Observer<List<ChatEntity>> { _allChats ->
            (recycChatList.adapter as ChatListAdapter).setNewItem(_allChats)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}
