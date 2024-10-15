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
            ItemModel(namaMenu = "Chicken Curry", R.drawable.curry, "29 Nov, 01:20 PM", "$50.50", "2 items"),
            ItemModel(namaMenu = "Burger", R.drawable.burger, "29 Nov, 01:20 PM", "$50.50", "2 items"),
            ItemModel(namaMenu = "Coffe Latte", R.drawable.coffe, "29 Nov, 01:20 PM", "$50.50", "2 items"),

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