package com.nisith.kotlindemoapp3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nisith.kotlindemoapp3.Adapters.MyRecyclerViewAdapter
import com.nisith.kotlindemoapp3.Model.Country

class CountryListActivity : AppCompatActivity(), MyRecyclerViewAdapter.OnItemClickListener{
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyRecyclerViewAdapter
    private lateinit var appToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        recyclerView = findViewById(R.id.recycler_view)
        appToolbar = findViewById(R.id.app_toolbar)
        setSupportActionBar(appToolbar)
        setupRecyclerViewWithAdapter()
    }
    private fun setupRecyclerViewWithAdapter(){
        var countryList: ArrayList<Country> = ArrayList()
        countryList.add(Country("India"))
        countryList.add(Country("Bangladesh"))
        countryList.add(Country("Sri Lanka"))
        countryList.add(Country("Bhutan"))
        countryList.add(Country("Nepal"))
        countryList.add(Country("America"))
        countryList.add(Country("England"))
        countryList.add(Country("Austrila"))
        countryList.add(Country("Germany"))
        countryList.add(Country("Poland"))
        adapter = MyRecyclerViewAdapter(countryList, this)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(countryName: String) {
        Toast.makeText(applicationContext, countryName, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_1 -> {
                Toast.makeText(applicationContext, "Item 1", Toast.LENGTH_SHORT).show()
            }
            R.id.item_2 -> {
                Toast.makeText(applicationContext, "Item 2", Toast.LENGTH_SHORT).show()
            }
            R.id.item_3 -> {
                Toast.makeText(applicationContext, "Item 3", Toast.LENGTH_SHORT).show()
            }
            R.id.item_4 -> {
                Toast.makeText(applicationContext, "Item 4", Toast.LENGTH_SHORT).show()
            }
            R.id.item_5 -> {
                Toast.makeText(applicationContext, "Item 5", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

}

