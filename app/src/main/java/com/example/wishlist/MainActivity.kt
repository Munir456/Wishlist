package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var submitButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private lateinit var wishes: ArrayList<Wishlist>
    private lateinit var itemName: EditText
    private lateinit var price: EditText
    private lateinit var link: EditText

// tv is just the items, et is for the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //put all into a list and display?
        wishes = ArrayList()
        adapter = WishlistAdapter(wishes)
        recyclerView = findViewById(R.id.wishList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        submitButton = findViewById(R.id.submit)
        itemName = findViewById(R.id.itemName)
        link = findViewById(R.id.link)
        price = findViewById((R.id.price))

        submitButton.setOnClickListener {

            val itemName1 = itemName.text.toString()
            val link1 = link.text.toString()
            val price1 = price.text.toString().toDouble()

            wishes.add(Wishlist("Name: $itemName1", "Price: $price1", "$link1"))
            adapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition((adapter.itemCount - 1))
            itemName.setText("")
            link.setText("")
            price.setText("")
        }
    }
}
