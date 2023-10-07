package com.example.wishlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView;

class WishlistAdapter(private val wishlists: ArrayList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val listItem: TextView
        val listPrice: TextView
        val listSite: TextView


        init {
            listItem = itemView.findViewById(R.id.listItem)
            listPrice = itemView.findViewById(R.id.listPrice)
            listSite = itemView.findViewById(R.id.listSite)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.wishlist_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlist = wishlists.get(position)
        // Set item views based on views and data model
        holder.listItem.text = wishlist.itemName
        holder.listPrice.text = wishlist.price
        holder.listSite.text = wishlist.link
    }

    override fun getItemCount(): Int {
        return wishlists.size
    }
}