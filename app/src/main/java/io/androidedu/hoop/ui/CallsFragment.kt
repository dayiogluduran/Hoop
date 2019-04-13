package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.util.GenerateDummyData
import kotlinx.android.synthetic.main.fragment_calls.*

class CallsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recyclerView_callList) {

            adapter = CallListAdapter(GenerateDummyData.getDummyCallList()) { callModel ->

                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }

            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): CallsFragment = CallsFragment()
    }
}
