package com.example.example.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.example.ProductDetails
import com.example.example.databinding.ProductItemBinding
import com.example.example.model.Product

class ProductAdapter (private val context: Context, private val productList: MutableList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var filteredList: MutableList<Product> = mutableListOf()

    init {
        filteredList.addAll(productList) // Инициализируем отфильтрованный список полным списком продуктов
    }

    // Метод для обновления отображаемого списка при изменении текста поиска
    fun filter(text: String) {
        filteredList.clear()
        if (text.isEmpty()) {
            filteredList.addAll(productList)
        } else {
            val search = text.toLowerCase().trim()
            productList.forEach { product ->
                if (product.name.toLowerCase().contains(search) || product.description.toLowerCase().contains(search)) {
                    filteredList.add(product)
                }
            }
        }
        notifyDataSetChanged() // Уведомляем адаптер об изменении данных
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val listItem = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(listItem)
    }

    override fun getItemCount() = filteredList.size // Используем размер отфильтрованного списка

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = filteredList[position] // Получаем продукт из отфильтрованного списка
        holder.imgProduct.setBackgroundResource(product.imgProduct)
        holder.name.text = product.name
        holder.description.text = product.description
        holder.price.text = product.price

        holder.btAdd.setOnClickListener{
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra("imgProduct", product.imgProduct)
            intent.putExtra("name", product.name)
            intent.putExtra("description", product.description)
            intent.putExtra("price", product.price)
            context.startActivity(intent)
        }
    }

    inner class ProductViewHolder(binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgProduct = binding.imgProduct
        val name = binding.txtName
        val description = binding.txtDescription
        val price = binding.txtPrice
        val btAdd = binding.btAdd
    }
}
