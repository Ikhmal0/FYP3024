package com.example.sweetbakery2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sweetbakery2.databinding.ItemOrderBinding
import com.example.sweetbakery2.model.Order

class OrderAdapter : ListAdapter<Order, OrderAdapter.OrderViewHolder>(OrderDiffCallback()) {

    // ViewHolder class to bind the data
    class OrderViewHolder(private val binding: ItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            Log.d("OrderAdapter", "Binding product name: ${order.productName}")  // Debug log for binding
            binding.order = order
            binding.executePendingBindings()  // Ensure data binding updates the UI immediately
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)  // Retrieve the item from the list
        holder.bind(order)  // Bind the order to the ViewHolder
    }

    // DiffUtil for efficient list updates
    class OrderDiffCallback : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem  // Adjust if there's a unique ID for orders
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem  // Compare full object contents
        }
    }
}
