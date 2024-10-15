package com.fadhiil2010.uts_mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.uts_mobile.Adapter.ItemAdapter
import com.fadhiil2010.uts_mobile.Model.ItemModel

class Order : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var iconAdapter: ItemAdapter
    private var itemList = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        recyclerView = findViewById(R.id.rvOrder)
        //ini kita bikin array data
        val listBuku = listOf(
            ItemModel(namaMenu = "Chicken Curry", R.drawable.curry, "29 Nov, 01:20 PM", "$50.50", "5 items"),
            ItemModel(namaMenu = "Burger", R.drawable.burger, "08 Maret, 01:20 PM", "$100.50", "10 items"),
            ItemModel(namaMenu = "Coffee Latte", R.drawable.coffe, "21 Jan, 00:20 PM", "$232.50", "3 items"),
            ItemModel(namaMenu = "Strawberry Cheesecake", R.drawable.iconstraw, "03 Oct, 09:30 AM", "$90.90", "2 items"),

        )
        val nBukuAdapter = ItemAdapter(listBuku)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Order)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}