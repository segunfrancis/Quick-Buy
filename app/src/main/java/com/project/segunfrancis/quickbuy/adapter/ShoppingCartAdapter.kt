package com.project.segunfrancis.quickbuy.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.database.ItemsRoomDatabase
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import com.project.segunfrancis.quickbuy.repository.ItemRepository
import kotlinx.android.synthetic.main.shopping_cart_list_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by SegunFrancis
 */

class ShoppingCartAdapter : RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>() {

    private var shoppingList: List<ShoppingCartItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        return ShoppingCartViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.shopping_cart_list_item, parent, false)
        )
    }

    override fun getItemCount() = shoppingList.size

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) =
        holder.bind(shoppingList[position])

    fun setData(shoppingList: List<ShoppingCartItem>) {
        this.shoppingList = shoppingList
        notifyDataSetChanged()
    }

    inner class ShoppingCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemDao = ItemsRoomDatabase.getDatabase(itemView.context, MainScope()).itemDao()
        private val repository = ItemRepository(itemDao)
        fun bind(item: ShoppingCartItem) = with(itemView) {
            shopping_item_name_text.text = item.name
            shopping_item_price_text.text = item.price
            shopping_item_quantity_text.text = item.quantity.toString()

            shopping_item_add_button.setOnClickListener {
                increment(shopping_item_quantity_text, item)
            }
            shopping_item_remove_button.setOnClickListener {
                decrement(shopping_item_quantity_text, item)
            }
            shopping_item_delete_button.setOnClickListener {
                CoroutineScope(Main).launch {
                    repository.deleteSingleItem(item)
                    notifyDataSetChanged()
                }
            }
        }

        private fun increment(textView: TextView, shoppingCartItem: ShoppingCartItem) {
            var currentQuantity = Integer.parseInt(textView.text.toString())
            if (currentQuantity < 100) {
                currentQuantity += 1
                shoppingCartItem.quantity = currentQuantity
                textView.text = currentQuantity.toString()
            } else {
                Toast.makeText(itemView.context, "Maximum quantity reached", Toast.LENGTH_SHORT).show()
            }
        }

        private fun decrement(textView: TextView, shoppingCartItem: ShoppingCartItem) {
            var currentQuantity = Integer.parseInt(textView.text.toString())
            if (currentQuantity > 1) {
                currentQuantity -= 1
                shoppingCartItem.quantity = currentQuantity
                textView.text = currentQuantity.toString()
            } else {
                Toast.makeText(itemView.context, "Minimum quantity reached", Toast.LENGTH_SHORT).show()
            }
        }
    }
}