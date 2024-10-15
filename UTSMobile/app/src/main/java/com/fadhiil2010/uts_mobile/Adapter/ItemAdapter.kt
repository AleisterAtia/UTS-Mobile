package com.fadhiil2010.uts_mobile.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.uts_mobile.Model.ItemModel
import com.fadhiil2010.uts_mobile.Order
import com.fadhiil2010.uts_mobile.R

class ItemAdapter(
    private val itemOrder: List<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.BukuAdapterHolder>() {

    //view holder yang digunakan unutk menyimpan referensi layout item
    class BukuAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgMenuDoctor: ImageView = itemView.findViewById(R.id.imgMenu)
        val txtNamaDoctor: TextView = itemView.findViewById(R.id.tvNamaMenu)
        val txtBidang: TextView = itemView.findViewById(R.id.tvTanggal)
        val txtRating: TextView = itemView.findViewById(R.id.tvharga)
        val txtAngkaRating: TextView = itemView.findViewById(R.id.tvItems)
    }

    //pengaturan data item pada setiap list dari recycle view
    override fun onBindViewHolder(holder: BukuAdapterHolder, position: Int) {
        val currentItem = itemOrder[position]
        holder.imgMenuDoctor.setImageResource(currentItem.imageMenu)
        holder.txtNamaDoctor.setText(currentItem.namaMenu)
        holder.txtBidang.setText(currentItem.Tanggal)
        holder.txtRating.setText(currentItem.Harga)
        holder.txtAngkaRating.setText(currentItem.totalItem)
    }

    //membuat layout list item sebagai item dari recycle view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuAdapterHolder {

        // Inflate layout item_destination.xml (pastikan file XML ini ada)
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return BukuAdapterHolder(nView)
    }

    //mengembalikan panjang nilai dari data
    override fun getItemCount(): Int{
        return itemOrder.size
    }

}