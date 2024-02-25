package com.example.example

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.example.databinding.ActivityProductDetailsBinding
import java.text.DecimalFormat

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        window.statusBarColor = Color.parseColor("#E0E0E0")

        val imgProduct = intent.extras!!.getInt("imgProduct")
        val name = intent.extras!!.getString("name")
        val description = intent.extras!!.getString("description")
        val price = intent.extras!!.getString("price")!!.toDouble()
        var newPrice = price
        val decimalFormat = DecimalFormat("#,###.## ₸")

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProdName.text = "$name"
        binding.txtProdPrice.text = decimalFormat.format(price)


        binding.btBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btIncr.setOnClickListener{
            if(amount == 1){
                binding.txtAmnt.text = "2"
                newPrice += price
                amount = 2
            }else if(amount == 2){
                binding.txtAmnt.text = "3"
                newPrice +=price
                amount = 3
            }
            binding.txtProdPrice.text = decimalFormat.format(newPrice)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.statusBarColor = Color.parseColor("#E0E0E0")
        }
    }

}