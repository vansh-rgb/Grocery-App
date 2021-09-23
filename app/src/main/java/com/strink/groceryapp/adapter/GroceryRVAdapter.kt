package com.strink.groceryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.strink.groceryapp.database.GroceryItems
import com.strink.groceryapp.databinding.GroceryRvItemBinding
import kotlin.coroutines.coroutineContext

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>(){

    private lateinit var binding: GroceryRvItemBinding


    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //binding initiated in onCreateViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        binding = GroceryRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GroceryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        with(holder) {
            binding.idTVItemName.text = list.get(position).itemName
            binding.idTVQuantity.text = list.get(position).itemQuantity.toString()

            val total:String = "Rs: "+list.get(position).itemPrice.toString()
            binding.idTVRate.text =  total
            binding.idTVTotalAmt.text = (list.get(position).itemQuantity*list.get(position).itemPrice).toString()
            binding.idTVDelete.setOnClickListener {
                groceryItemClickInterface.onItemClick(list.get(position))
            }
        }
    }

    interface GroceryItemClickInterface {
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}