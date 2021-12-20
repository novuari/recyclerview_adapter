package com.novu.adapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.novu.adapter.GAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.list)

        val adapter = GAdapter<String>(R.layout.item_string, BR.str_s)
        adapter.setList(listOf("one", "two", "three", "four", "five"))
        rv.adapter = adapter
    }
}