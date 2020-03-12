package com.project.segunfrancis.quickbuy.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.model.ShoppingCartItem
import com.project.segunfrancis.quickbuy.utils.Constants.SERIALIZABLE_KEY
import com.project.segunfrancis.quickbuy.viewModel.ItemViewModel

/**
 * A simple [Fragment] subclass.
 */
class ItemDetailsFragment : DialogFragment() {

    private lateinit var itemViewModel: ItemViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = MaterialAlertDialogBuilder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_item_details, null)
        builder.setView(view)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        if (arguments != null) {
            val item = arguments!!.getSerializable(SERIALIZABLE_KEY) as Item
            view.findViewById<TextView>(R.id.item_details_name).text = item.name
            view.findViewById<TextView>(R.id.item_details_description).text = item.description
            view.findViewById<TextView>(R.id.item_details_price).text = "$".plus(item.price)
            view.findViewById<ImageView>(R.id.item_details_image)
                .setImageResource(item.imageResource)

            view.findViewById<Button>(R.id.item_details_addToCart_button).setOnClickListener {
                val shoppingCartItem = ShoppingCartItem(item.name, item.price, 1)
                //itemViewModel.insertIntoShoppingCartItem(shoppingCartItem)
            }
        }
        return builder.create()
    }
}
