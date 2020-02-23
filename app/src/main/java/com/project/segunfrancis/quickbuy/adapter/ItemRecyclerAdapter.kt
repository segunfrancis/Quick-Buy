package com.project.segunfrancis.quickbuy.adapter

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.utils.Constants.SERIALIZABLE_KEY
import kotlinx.android.synthetic.main.shopping_item_layout.view.*
import java.util.*

/**
 * Created by SegunFrancis
 */

class ItemRecyclerAdapter : RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>() {

    private var itemList: List<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.shopping_item_layout, parent, false)
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(itemList[position])

    fun setData(itemList: List<Item>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) = with(itemView) {
            // Bind the itemList with View
            item_image.setImageResource(item.imageResource)
            item_name.text = item.name
            item_price.text = item.price

            setOnClickListener {
                // Handle on click
                val bundle = Bundle()
                bundle.putSerializable(SERIALIZABLE_KEY, item)
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_itemDetailsFragment, bundle)
            }
        }
    }
}