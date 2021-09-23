package com.strink.groceryapp.model

import androidx.lifecycle.ViewModel
import com.strink.groceryapp.database.GroceryItems
import com.strink.groceryapp.database.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository):ViewModel() {

    fun insert(items:GroceryItems) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items:GroceryItems) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllGroceryItems() = repository.getAllItems()
}