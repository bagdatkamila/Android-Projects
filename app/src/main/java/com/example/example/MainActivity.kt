package com.example.example

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.example.adapter.ProductAdapter
import com.example.example.databinding.ActivityMainBinding
import com.example.example.listItems.Products
import com.example.example.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch
import androidx.appcompat.widget.SearchView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()
    var clicked = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed{ index, value ->
                for(p in value) productList.add(p)
            }
        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this, 2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this, productList)
        recyclerViewProducts.adapter = productAdapter

        binding.buttonSearch.setOnClickListener{
            val query = binding.editTextSearch.text.toString()
            productAdapter.filter(query)
        }

        binding.btPizza.setOnClickListener{
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPizza.setTextColor(Color.rgb(255, 105, 0))
                binding.btCombo.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCombo.setTextColor(Color.rgb(158, 158, 158))
                binding.btCoffee.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCoffee.setTextColor(Color.rgb(158, 158, 158))
                binding.btSnacks.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSnacks.setTextColor(Color.rgb(158, 158, 158))
                binding.btDessert.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btDessert.setTextColor(Color.rgb(158, 158, 158))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Пиццы"
            }
        }

        binding.btCombo.setOnClickListener{
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(Color.rgb(158, 158, 158))
                binding.btCombo.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btCombo.setTextColor(Color.rgb(255, 105, 0))
                binding.btCoffee.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCoffee.setTextColor(Color.rgb(158, 158, 158))
                binding.btSnacks.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSnacks.setTextColor(Color.rgb(158, 158, 158))
                binding.btDessert.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btDessert.setTextColor(Color.rgb(158, 158, 158))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Комбо"
            }
        }

        binding.btCoffee.setOnClickListener{
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(Color.rgb(158, 158, 158))
                binding.btCombo.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCombo.setTextColor(Color.rgb(158, 158, 158))
                binding.btCoffee.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btCoffee.setTextColor(Color.rgb(255, 105, 0))
                binding.btSnacks.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSnacks.setTextColor(Color.rgb(158, 158, 158))
                binding.btDessert.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btDessert.setTextColor(Color.rgb(158, 158, 158))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Кофе"
            }
        }

        binding.btSnacks.setOnClickListener{
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(Color.rgb(158, 158, 158))
                binding.btCombo.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCombo.setTextColor(Color.rgb(158, 158, 158))
                binding.btCoffee.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCoffee.setTextColor(Color.rgb(158, 158, 158))
                binding.btSnacks.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btSnacks.setTextColor(Color.rgb(255, 105, 0))
                binding.btDessert.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btDessert.setTextColor(Color.rgb(158, 158, 158))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Снэки"
            }
        }

        binding.btDessert.setOnClickListener{
            clicked = true
            if(clicked){
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(Color.rgb(158, 158, 158))
                binding.btCombo.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCombo.setTextColor(Color.rgb(158, 158, 158))
                binding.btCoffee.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCoffee.setTextColor(Color.rgb(158, 158, 158))
                binding.btSnacks.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSnacks.setTextColor(Color.rgb(158, 158, 158))
                binding.btDessert.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btDessert.setTextColor(Color.rgb(255, 105, 0))
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtListTitle.text = "Десерт"
            }
        }


    }

}