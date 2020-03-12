package com.project.segunfrancis.quickbuy.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.project.segunfrancis.quickbuy.Injection

import com.project.segunfrancis.quickbuy.R
import com.project.segunfrancis.quickbuy.adapter.ItemRecyclerAdapter
import com.project.segunfrancis.quickbuy.viewModel.ItemViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope

/**
 * A simple [Fragment] subclass.
 */
class CameraFragment : Fragment() {

    private lateinit var itemViewModel: ItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_camera, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.camera_recyclerView)
        val adapter = ItemRecyclerAdapter()
        recyclerView.adapter = adapter

        /*itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        itemViewModel.cameras.observe(viewLifecycleOwner, Observer { item ->
            item.let {
                adapter.setData(it)
            }
        })*/
        return root
    }
}
