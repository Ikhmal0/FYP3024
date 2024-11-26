package com.example.sweetbakery2


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sweetbakery2.R

class ProductAdapter(
    private val productList: List<Product>,
    private val onOrderClick: (Product, Int) -> Unit // Callback for placing an order
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.tvProductName)
        val productPrice: TextView = view.findViewById(R.id.tvProductPrice)
        val productImage: ImageView = view.findViewById(R.id.ivProductImage)
        val btnOrder: Button = view.findViewById(R.id.btnOrder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
        holder.productPrice.text = "RM ${product.price}"

        // Decode Base64 string and display the image
        val decodedImage = decodeBase64(product.imageUrl)
        if (decodedImage != null) {
            Glide.with(holder.itemView.context)
                .load(decodedImage) // Pass the decoded Bitmap
                .placeholder(R.drawable.ic_placeholder)
                .into(holder.productImage)
        } else {
            // Load a placeholder image if decoding fails
            Glide.with(holder.itemView.context)
                .load(R.drawable.ic_placeholder)
                .into(holder.productImage)
        }

        holder.btnOrder.setOnClickListener {
            onOrderClick(product, holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = productList.size

    // Helper method to decode Base64 string to Bitmap
    private fun decodeBase64(base64String: String): Bitmap? {
        return try {
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}
