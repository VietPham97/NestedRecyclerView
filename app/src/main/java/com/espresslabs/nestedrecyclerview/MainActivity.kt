package com.espresslabs.nestedrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView_main.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayout.VERTICAL,
                false
            )
            adapter = ParentAdapter(ParentDataFactory.getParents(40))
        }
    }
}
