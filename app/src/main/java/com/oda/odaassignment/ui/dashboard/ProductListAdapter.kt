package com.oda.odaassignment.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oda.odaassignment.databinding.AdapterListitemProductBinding
import com.oda.odaassignment.model.Product

/**Created by srshe on 18-February-2022**/
class ProductListAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var products = mutableListOf<Product>()

    fun setProductList(movies: List<Product>) {
        this.products = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterListitemProductBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val product = products[position]
        holder.binding.txtProductName.text = product.fullName
        holder.binding.txtProductNameExtra.text = product.nameExtra
        val currency = if ( product.currency.equals("NOK") )"kr" else "$"
        (product.grossUnitPrice +" "+ currency).also { holder.binding.txtProductGrossUnitPrice.text = it }
        (product.grossPrice +" "+ currency).also { holder.binding.txtProductGrossPrice.text = it }
        Glide.with(holder.itemView.context).load(product.images[0].thumbnail?.url).into(holder.binding.imgProduct)

        holder.binding.btnProductAdd.setOnClickListener(View.OnClickListener {

            Toast.makeText(holder.binding.imgProduct.context, product.name+" added to cart", Toast.LENGTH_SHORT).show()

        })

    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class MainViewHolder(val binding: AdapterListitemProductBinding) : RecyclerView.ViewHolder(binding.root) {

}