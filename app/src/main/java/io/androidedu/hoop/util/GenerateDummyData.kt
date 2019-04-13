package io.androidedu.hoop.util

import io.androidedu.hoop.R
import io.androidedu.hoop.model.CallModel
import io.androidedu.hoop.model.ChatModel
import io.androidedu.hoop.model.StatusModel

object GenerateDummyData {

    fun getDummyChatList(): ArrayList<ChatModel> = ArrayList<ChatModel>().apply {

        val chatModel = ChatModel(
                R.drawable.ic_person,
                "Duran DAYIOGLU",
                "Helloo!",
                "Yesterday")

        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)
        add(chatModel)

    }

    fun getDummyStatusList(): ArrayList<StatusModel> = ArrayList<StatusModel>().apply {

        val statusModel = StatusModel(
                R.drawable.ic_person,
                "Duran DAYIOGLU",
                "Today",
                "14:00"
        )

        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
        add(statusModel)
    }

    fun getDummyCallList(): ArrayList<CallModel> = ArrayList<CallModel>().apply {

        val callModel = CallModel(
                R.drawable.ic_person,
                "Duran DAYIOGLU",
                "Today",
                "14:00",
                R.drawable.ic_call
        )
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
        add(callModel)
    }
}