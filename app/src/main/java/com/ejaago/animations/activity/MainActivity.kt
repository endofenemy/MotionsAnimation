package com.ejaago.animations.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ejaago.animations.R
import com.ejaago.animations.adapters.ItemAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.also {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = ItemAdapter()
        }
    }
}
