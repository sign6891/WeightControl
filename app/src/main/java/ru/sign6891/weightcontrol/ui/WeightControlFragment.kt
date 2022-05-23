package ru.sign6891.weightcontrol.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.sign6891.weightcontrol.R
import ru.sign6891.weightcontrol.data.WeightControlApplication
import ru.sign6891.weightcontrol.ui.adapter.ElementListAdapter
import ru.sign6891.weightcontrol.ui.base.BaseFragment


class WeightControlFragment : BaseFragment() {

    companion object {
        public val NAVIGATION_LABEL = "WeightControlFragment"
    }


    private val mViewModel: WeightControlViewModel by viewModels {
    WeightControlViewModelFactory((activity as WeightControlApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weight_control, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ElementListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        /* mViewModel.allDataElement.observe(viewLifecycleOwner, Observer { dataElement ->
             dataElement?.let { adapter.submitList(it) }
         })*/

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureFloatingActionButton()
    }

    private fun configureFloatingActionButton() {
        val navigationIconId = 0
        val fabIconId = R.drawable.ic_add
        configureFloatingActionButton(navigationIconId, fabIconId)
    }

}