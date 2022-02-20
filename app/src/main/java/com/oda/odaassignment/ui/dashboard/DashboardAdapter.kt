package com.oda.odaassignment.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.oda.odaassignment.R
import com.oda.odaassignment.model.Block
import com.oda.odaassignment.model.Component

/**Created by srshe on 18-February-2022**/
class DashboardAdapter : RecyclerView.Adapter<DashboardViewHolder>() {

    private var blocks = MutableLiveData<Block>()

    fun setData(blocks: Block) {
        this.blocks.value = blocks
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.adapter_item_component_header
            TYPE_LIST -> R.layout.adapter_item_component_list
            else -> throw IllegalArgumentException("Invalid Type")
        }

        val binding = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val blocks = blocks.value
        val component = blocks?.blocks?.get(position)
        holder.bind(component!!)
    }

    override fun getItemCount(): Int {
        val blockData = blocks.value
        return blockData?.blocks?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        val blocks = blocks.value
        val component = blocks?.blocks?.get(position)

        return when (component?.component) {
            "header" -> TYPE_HEADER
            "list" -> TYPE_LIST
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_LIST = 1
    }
}


class DashboardViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {
    private fun bindHeader(component: Component) {

        itemView.findViewById<TextView>(R.id.txtMainHeader).text = component.title
        itemView.findViewById<Button>(R.id.btnMainHeader).text = component.button?.title
        itemView.findViewById<Button>(R.id.btnMainHeader).setOnClickListener(View.OnClickListener {
            val url = component.button?.target?.uri
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            itemView.context.startActivity(intent)
        })

    }

    private fun bindList(component: Component) {
        itemView.findViewById<TextView>(R.id.txtListTitle).text = component.title
        val listView = itemView.findViewById<RecyclerView>(R.id.recyclerViewProductList)
        val adapter = ProductListAdapter()
        adapter.setProductList(component.products)
        listView.adapter = adapter
        listView.apply {
            setHasFixedSize(true)
            val itemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.divider)!!)
            addItemDecoration(itemDecoration)
        }
    }

    fun bind(component: Component) {
        when (component.component) {
            "header" -> bindHeader(component)
            "list" -> bindList(component)
        }
    }
}