package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.dao.CallDao
import io.androidedu.hoop.db.HoopDb
import io.androidedu.hoop.entity.CallEntity
import kotlinx.android.synthetic.main.fragment_calls.*
import kotlin.concurrent.thread

class CallsFragment : Fragment() {

    private val hoopDb: HoopDb? by lazy { HoopDb.getInstance(context!!) }
    private val callDao: CallDao? by lazy { hoopDb?.getCallDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callEntity = CallEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "Duran Call",
                callDate = "Today",
                callTime = "14:00",
                callIcon = R.drawable.ic_call
        )

        val callEntity2 = CallEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "Dayıoğlu Call",
                callDate = "Today",
                callTime = "14:00",
                callIcon = R.drawable.ic_call
        )


        thread(start = true) {
            callDao?.addnewCall(callEntity)
            callDao?.addnewCall(callEntity2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(recyclerView_callList) {
            adapter = CallListAdapter { _callEntity ->
                kotlin.concurrent.thread(start = true) {
                    callDao?.removeItem(_callEntity)
                }
            }
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        }

        callDao?.getAllCalls()?.observe(this, Observer<List<CallEntity>> { _allCalls ->
            (recyclerView_callList.adapter as CallListAdapter).setNewItem(_allCalls)
        })
    }

    companion object {

        @JvmStatic
        fun newInstance(): CallsFragment = CallsFragment()
    }
}
