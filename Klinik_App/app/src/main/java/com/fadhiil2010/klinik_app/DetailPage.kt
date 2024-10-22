package com.fadhiil2010.klinik_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)

        val nama = intent.getStringExtra("namaDokter")
        val photo = intent.getIntExtra("photoDokter", 0)
        val bidang = intent.getStringExtra("bidangDr")
        val total = intent.getStringExtra("totalReview")
        val angka = intent.getStringExtra("angkaReview")


        val txtnama = findViewById<TextView>(R.id.tvNamaDoctor)
        val imgphoto = findViewById<ImageView>(R.id.imgDoctor)
        val txtbidang = findViewById<TextView>(R.id.tvBidang)
        val txttotal = findViewById<TextView>(R.id.tvRating)
        val txtangka = findViewById<TextView>(R.id.tvAngkaRating)


        txtnama.text = nama
        imgphoto.setImageResource(photo)
        txtbidang.text = bidang
        txttotal.text = total
        txtangka.text = angka


       
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}