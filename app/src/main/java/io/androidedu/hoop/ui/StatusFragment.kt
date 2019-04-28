package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.StatusListAdapter
import io.androidedu.hoop.dao.StatusDao
import io.androidedu.hoop.db.HoopDb
import io.androidedu.hoop.entity.StatusEntity
import kotlinx.android.synthetic.main.fragment_status.*
import kotlin.concurrent.thread

class StatusFragment : Fragment() {

    private val hoopDb: HoopDb? by lazy { HoopDb.getInstance(context!!) }
    private val statusDao: StatusDao? by lazy { hoopDb?.getStatusDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val statusEntity = StatusEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "DuranD Status",
                statusDate = "Today?",
                statusTime = "14:00"
        )

        val statusEntity2 = StatusEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "İlknurA Status",
                statusDate = "Yesterday",
                statusTime = "14:00"
        )
        val statusEntity3 = StatusEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "DilekS Status",
                statusDate = "Today",
                statusTime = "14:00"
        )

        val statusEntity4 = StatusEntity(
                profilePhoto = R.drawable.ic_person,
                userName = "GökhanS Status",
                statusDate = "Today?",
                statusTime = "14:00"
        )

        thread(start = true) {
            statusDao?.addNewStatus(statusEntity)
            statusDao?.addNewStatus(statusEntity2)
            statusDao?.addNewStatus(statusEntity3)
            statusDao?.addNewStatus(statusEntity4)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recylerView_statusList) {
            adapter = StatusListAdapter { _statusEntity ->
                thread(start = true) {
                    statusDao?.deleteStatus(_statusEntity)
                }
            }
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        }

        statusDao?.getAllStatus()?.observe(this, Observer<List<StatusEntity>> { _allStatus ->
            (recylerView_statusList.adapter as StatusListAdapter).setNewItem(_allStatus)
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
    }
}
