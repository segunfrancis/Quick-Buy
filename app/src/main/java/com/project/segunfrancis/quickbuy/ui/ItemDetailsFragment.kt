package com.project.segunfrancis.quickbuy.ui

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.model.Item
import com.project.segunfrancis.quickbuy.utils.Constants.SERIALIZABLE_KEY

/**
 * A simple [Fragment] subclass.
 */
class ItemDetailsFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = MaterialAlertDialogBuilder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_item_details, null)
        builder.setView(view)
        if (arguments != null) {
            val item = arguments!!.getSerializable(SERIALIZABLE_KEY) as Item
            view.findViewById<TextView>(R.id.item_details_name).text = item.name
            view.findViewById<TextView>(R.id.item_details_description).text = item.description
            view.findViewById<TextView>(R.id.item_details_price).text = item.price
            view.findViewById<ImageView>(R.id.item_details_image).setImageResource(item.imageResource)
        }
        return builder.create()
    }

}
