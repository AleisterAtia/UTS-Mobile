package com.fadhiil2010.klinik_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.klinik_app.adapter.AdapterMenuDoctor
import com.fadhiil2010.klinik_app.adapter.AdapterMenuIcon
import com.fadhiil2010.klinik_app.model.ModelIcon
import com.fadhiil2010.klinik_app.model.ModelListDoctor

class Doctors : AppCompatActivity() {

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : AdapterMenuIcon

    private lateinit var RecyclerViewDoctor : RecyclerView
    private lateinit var AdapterDoctor : AdapterMenuDoctor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors)




        val ActButton1 = findViewById<TextView>(R.id.tvKembali)
        ActButton1.setOnClickListener {
            val Intent = Intent(this, SignIn::class.java)
            startActivity(Intent)
        }

        val menuIcons = listOf(
            ModelIcon(R.drawable.iconheart,"cardiologist"),
            ModelIcon(R.drawable.iconeye,"Ophthalmologyst"),
            ModelIcon(R.drawable.icontooth,"Dentist")
        )


        // Inisialisasi RecyclerView
        RecyclerViewMenu = findViewById(R.id.rvCardiologyst)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = AdapterMenuIcon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        // Set LayoutManager untuk RecyclerView



        val menudokter = listOf(
            ModelListDoctor("Dr.Floyd Miles",R.drawable.dokter1,"Pediatrics","(123 reviews)","4.9"),
            ModelListDoctor("Dr.Guy Hawkins",R.drawable.dokter2,"Dentist","(85 reviews)","4.9"),
            ModelListDoctor("Dr.Jane Cooper",R.drawable.dokter3,"Cardiologist","(44 reviews)","4.7"),
            ModelListDoctor("Dr.Jacob Jones",R.drawable.dokter4,"Nephrologyst","(101 reviews)","5.0"),
            ModelListDoctor("Dr.Savannah Nguyen",R.drawable.dokter5,"Urologist","(168 reviews)","4.8")
        )

        RecyclerViewDoctor = findViewById(R.id.rvDoctors)
        RecyclerViewDoctor.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        AdapterDoctor= AdapterMenuDoctor(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor

        // Menangani window insets (padding untuk status bar dll.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
