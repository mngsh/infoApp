package com.example.testapp.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.presentation.main.adapter.ItemClickListener
import com.example.testapp.presentation.main.adapter.RecyclerAdapter

class MainFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    private val viewModel: MainViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        adapter = RecyclerAdapter(object: ItemClickListener{
            override fun onClicked(item: Int) {
                findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
            }
        })
        recyclerView.adapter = adapter

        viewModel.peopleListLiveData.observe(viewLifecycleOwner, Observer { listPeople ->
            adapter.update(listPeople)
        })
    }
}