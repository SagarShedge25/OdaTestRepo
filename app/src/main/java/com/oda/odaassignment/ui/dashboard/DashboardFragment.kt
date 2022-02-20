package com.oda.odaassignment.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.oda.odaassignment.R
import com.oda.odaassignment.data.DefaultTasksRepository
import com.oda.odaassignment.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var dashboardBinding: FragmentDashboardBinding? = null
    private val dashboardAdapter = DashboardAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(
                this,
                DashBoardViewModelFactory(DefaultTasksRepository())
            )[DashboardViewModel::class.java]

        dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = dashboardBinding!!.root

        dashboardBinding!!.recyclerViewDashboard.adapter = dashboardAdapter
        dashboardViewModel.blocks.observe(viewLifecycleOwner, Observer {
            dashboardAdapter.setData(it)
        })

        dashboardViewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) {
                dashboardBinding!!.progressDialog.visibility = View.VISIBLE
            } else {
                dashboardBinding!!.progressDialog.visibility = View.GONE
            }
        })

        dashboardViewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        dashboardBinding!!.recyclerViewDashboard.apply {
            setHasFixedSize(true)
            val itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.rv_dash_divider
                )!!
            )
            addItemDecoration(itemDecoration)
        }

        dashboardViewModel.setBlocks()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dashboardBinding = null
    }
}